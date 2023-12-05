package com.kh.springdb.vo;

import java.util.Date;

import com.kh.springdb.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="UserPage")
public class Usermodel extends BaseTimeEntity{
	
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="user_seq")
	@SequenceGenerator(name="user_seq",sequenceName="user_seq",allocationSize=1)
	@Id
	private Long userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	private Date regDate;
	
}
