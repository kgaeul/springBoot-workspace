package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.Item;
import com.kh.springdb.service.CartService;
import com.kh.springdb.service.ItemService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private final CartService cartService;
	private final ItemService itemService;
	
	public CartController(CartService cartService,ItemService itemService) {
		this.cartService=cartService;
		this.itemService=itemService;
	}
	
	
	//장바구니 목록
	@GetMapping()
	public String viewCart(Model model) {
		Cart cart = cartService.getCartById(1L);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	
	//주소에 접속하기 위해 GetMapping
	@GetMapping("/add/{itemId}")
	public String addToCart(@PathVariable("itemId") int itemId,Model modl){

		//장바구니에 상품추가
		Item newItem = itemService.getItemById(itemId);
		/*@PathVariable Long itemId
		만약에 파라미터 값이 Long일 경우에는 longValue()작성을 해주고 intValue() Integer 쓴 객체를 int로 변환하는 메서드
		Integer와 int의 차이
		Integer = Wrapper클래스로 감싸져 있기 때문에 null 값을 가질 수 있음
		int = 자바에서 기본 데이터 타입, 정수를 나타내기 때문에 null값을 가질 수 없음
		*/
		cartService.addCart(1L, newItem, 1);
		/*갑자기 1L이 머농.......
		  cartService.addCart=>장바구니이기 때문에 누가 가지고 있는지에 대한 값을 지정
		  임의의 값을 지정해 줄때 1L이라는 표현을 쓰기도 함
		 */
		return "redirect:/cart";
	}

	@PostMapping("/add")
	public String addToCartPost(@RequestParam("itemId")Long itemId , Model model) {
		Item newItem = itemService.getItemById(itemId.intValue());
											//1L 유저아이디값/새로운 아이템추가/카트에 추가할 수량
		cartService.addCart(1L, newItem,1);
		return "redirect:/cart";
	}
	
	@PostMapping("/checkout")
	public String checkout(RedirectAttributes redirectAttribute) {
		Long cartId=1L;
		
		try {
			cartService.checkout(cartId);
			redirectAttribute.addFlashAttribute("checkoutStatus", "success");
		}catch(Exception e){
			redirectAttribute.addFlashAttribute("checkoutStatus", "empty");
		}
		return "redirect:/cart";
	}
	
	/*
	 redirectAttribute : 리다이렉트할 때 속성을 전달하는 데 사용
	 addFlashAttribute : 데이터를 추가할 때 리다이렉트 후 한 번만 사용 가능 
	 사용 후에는 속성이 자동으로 삭제됨 리다이렉트해서 돌아가고자하는 페이지로 이동할 때 속성이 존재하고, 돌아간 페이지에서 속성을 사용할 수 있음
	 */
}
