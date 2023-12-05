package com.kh.springdb.service;

import java.io.File;
import java.util.*;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.vo.item;
import com.kh.springdb.repository.ItemRepository;

@Service
public class ItemService {

	//상품을 추가하고 삭제하고 수정하는 기능
	@Autowired
	private ItemRepository itemrepository;
	
	
	//아이템 테이블에서 아이템 추가하기
	public void addItem(item item, MultipartFile photoFile) {
		
		//이미지 파일 정보에 대해서 추출
		String originPhotoName = photoFile.getOriginalFilename();//->업로드된 이미지 파일의 원본 파일명을 가져옵니다.
		String photoName="";
		String photoPath = System.getProperty("user.dir") + "src/main/resources/static/uploadImg/"; //업로드된 이미지 파일 경로 설정
		//System.getProperty("user.dir") 현재 코드가 작업하고 있는 폴더 위치 
		//System.getProperty() : 현재 작업하는 폴더 위치
		//user.dir = 작업하는 사용자 클래스 폴더의 위치를 나타냄 상세한 위치를 줄여놓은 것
		
		String saveFileName="khShop_"+originPhotoName;
		//파일 저장할 이름 설정 저장할 떄마다 자동으로 앞에 khShop이 붙음
		
		photoName=saveFileName;
		//빈 값에다가 한번 더 재정의로 넣어줌
		
		File saveFile = new File(photoPath,photoName);
		//파일을 저장하기 위해 우리가 작성해놓은 파일을 작성하기 위한 공간이 비어있는 File 객체를 가지고 옴 파일을 저장할 경로  파일명
		//저장하기 귀찮으면 originPhotoName 이대로 저장해도 됨 컴터에 있는 이름 그대로 업로드 됨
		
		photoFile.transferTo(saveFile);
		//업로드 된 이미지 파일을 지정된 경로에 저장하기 위해 설정
		//transferTo 서버에 특정 경로에 저장할 수 있도록 해주는 메서드
		
		item.setPhotoName(photoName);
		item.setPhotoPath("/img/"+photoName);
		
		itemrepository.save(item);
	}
	
	//아이템 테이블에서 아이템 확인하기
	public item getItemById(Integer id) {
		return itemrepository.findById(id).get();
		//.findById(id).get(); =>
		//findByID 를 사용해서 Id에 해당하는 값을 가져오고 
		//get()을 이용해서 item 객체를 반환
	}
	
	//모든 상품 확인하기
	public List<Item> allItemList(){
		return itemrepository.findAll();
	}
	
	public void itemDelete(Integer id) {
		itemrepository.deleteById(id);
	}
}
