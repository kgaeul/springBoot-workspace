package com.kh.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.board.vo.board;

public interface repository extends JpaRepository<board,Long>{

	//게시판에서 제목에 특정 키워드가 포함된 게시물을 검색
	@Query("select b from board b where b.title like %:keyword%")
	List <board> findTitle(@Param(("keyword"))String keyword);
	
/*	%:keyword%: keyword 파라미터로 받아온 키워드를 나타냄
	%어떤 문자열이라도 매칭이 될수 있도록 도와주는 역할을 함
	List<board>: 검색결과를 리스트 형태로 반환할 수 있도록 해줌
	
	@Param(("keyword")) : keyword의 값을 쿼리 내의  :keyword에 매핑시킴
	
	
	
	@Query("select * from board where title like %:keyword%")
	@Query("select b from board b where b.title like %:keyword%")
	
	board b를 붙이는 것과 안붙이는 것은 엔티티에서 별칭을 지정해서 사용하는 방식 
	JPQL(Java Persistence Query Language)
		Java 객체를 대상으로 하는 쿼리
		JPA(Java Persistance API) 사용함
		엔티티 객체와 필드에 대한 쿼리를 정의하는 데 사용
		직접 생성해서 쿼리를 정의할 떄 사용하는 어노테이션 
	
	*/
}




