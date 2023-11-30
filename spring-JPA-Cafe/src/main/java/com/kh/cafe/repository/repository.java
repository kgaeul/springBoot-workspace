package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.cafe.vo.cafe;

public interface repository extends JpaRepository<cafe,Long>{

	@Query("select c from cafe c where c.name like %:word%")
	List <cafe> findCafe(@Param("word") String word);
	
	//특정 문자열을 포함한 엔터티를 검색하는 데 사용하는 메서드
	List<cafe> findByNameContaining(String word);
}
