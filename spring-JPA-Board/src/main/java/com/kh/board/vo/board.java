package com.kh.board.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="board")

public class board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="board_add_sequence") 
	@SequenceGenerator(name="board_add_sequence", sequenceName="board_add_sequence", allocationSize = 1)
	private Long board_id;
	
	private String title;
	
	private String content ;
	
	private String author;
	
}


/*
	@Culumn 
	테이블안에 컬럼을 생성하거나 존재하는 테이블에 컬럼값을 찾아 매핑하는 역할을 함 option
		-name : 데이터베이스에 존재하는 컬럼이름과 자바 클래스에서 존재하는 필드이름이 일치하지 않을 경우 
		자바와 데이터베이스 값이 일치할 수 있도록 매핑 해주는 역할
		-unique : 유니크 제약조건 설정
		-insertable : insert 가능 여부
		-updateable : update 가능 여부
		-length : String 타입의 문자 길이 제약조건 설정 
		columnDefination : 데이터베시으 컬럼정보 직접 기술
			@Column(columnDefination = "varchar(10)" not null
			precsion: 큰 값에서 사용할 수 있음 소수점을 포함한 전체 자리수
			scale(DDL) : 소수점 자리수 Double과 float 타입에는 적용되지 않음
			
		
		@GeneratedValue(starategy = GeneratedType.)
			GeneratedType.AUTO(default) : JPA 자동으로 알아서 생성 전략 결정
			GeneratedType.SEQUENCE : 데이터베이스 시퀀스를 이용해서 기본키를 생성
									 간혹 @SequenceGerateor를 사용해서 시퀀스를 등록할 필요가 없음
			
			GeneratedType.TABLE : 키 생성용 테이블 사용 @TableGenerator 필요
			GeneratedType.IDENTITY : 기본키 생성을 데이터베이스에 넘겨줌
									 ex)mysql 데이터의 경우 AUTO_INCREMENT 사용해서 기본키를 생성
*/