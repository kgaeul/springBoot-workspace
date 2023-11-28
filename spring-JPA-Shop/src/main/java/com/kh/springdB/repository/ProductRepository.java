package com.kh.springdB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kh.springdB.vo.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}

//	Product findByProductName(String product_name);
		//예제
//		Product product = new Product();
//		product.setProduct_name("테스터 제품");
//		product.setPrice(1000);
//		product.setCategory("가전");
		
		//전체제품 출력하는 메서드 추가
//		List<Product> findByPrice(Integer Price);
//		
//		@Query("select*from ProductItem where price")
//		List<Product> findByDetail(@Param("category") String category);
//		
//		
//		//만약에  repository에 쿼리를 추가하고 싶을 경우
//	}
/*
 
 Repository
 	Spring Data JPA에서 제공하는 인터페이스
 	데이터베이스에서 User 엔터티에 접근하는 데 사용
 	기본적인 CRUD 작업을 수행할 수 있는 메서드를 제공
 	
 	예를 들어 
 		조회 : 전체조회(findAll) 아이디 하나만 조회(findById)
 		저장 : save
 		삭제 : deleteById
 		
 
 */