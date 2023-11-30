package com.kh.board.controller;

import java.util.List;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.board.service.service;
import com.kh.board.vo.board;

@Controller
@RequestMapping("/board")
public class controller {

	@Autowired
	private service s;
	
	public controller(service s) {
		this.s=s;
	}
	
	@GetMapping("/list")
	public String boardgetAll(Model model) {
		List<board> boardlist = s.getAllBoard();
		model.addAttribute("boards",boardlist);
		return "board.html";
	}
	
	@GetMapping("/detail/{id}")
	public String boardDetail(@PathVariable Long id,Model model) {
		Optional<board> b = s.getBoardBiId(id);
		b.ifPresent(value -> model.addAttribute("board",value));
		return "boardDetail.html";
	}
	
	//특정 키워드를 활용해서 게시물 검색하는 Mapping메서드
	
	@GetMapping ("/search")
	public String searchBoards(@RequestParam String keyword, Model model) {
		//특정 키워드를 포함해서 게시물 검색할 수 있도록 설정
		List<board> boards = s.findBoardByTitle(keyword);
		
		//모델에 검색결과 추가
		model.addAttribute("boards", boards);
		
		//검색결과를 보여줄 페이지 리턴
		return "searchresult";
	}
}



/*
  @RequestParam : Spring 프레임워크에서 클라이언트로부터 전송된 HTTP 요청의 파라미터 값을 받아오기 위해 사용되는 어노테이션
  주로 웹 요청에서 쿼리 파라미터나 폼 데이터를 추출하는 데 사용 클라이언트가 전송한 요청의 파라미터 값을 메서드의 매개변수로 받아올 때 사용한다
  
  예제코드 :
  	@GetMapping("/ex")
  	public String paramMethod(@RequestParam String name, @RequestParam int age){
  	//name, age는 클라이언트가 전송한 요청의 쿼리 파라미터 값
  	
  	return "View";
  	
  	}
  	
  
  
 */
 