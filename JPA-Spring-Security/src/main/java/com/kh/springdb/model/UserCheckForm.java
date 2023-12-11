package com.kh.springdb.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//아이디나 비밀번호가 적혀있지 않거나 최대값 최소값을 설정해주기 위해 form을 체크해주는 class
//무결성 제약조건에 어긋나는 지 확인하는 폼

@Getter
@Setter
public class UserCheckForm {

	//최댓값 최솟값을 설정해주고 , 빈값이면 적용되지 않게 하기 위해 빈값 관련문구 설정
	@Size(min=2,max=8)
	@NotEmpty(message="사용자 ID는 필수로 입력해야합니다.")
	private String username;
	
	@NotEmpty(message="비밀번호는 필수로 입력해야합니다.")
	private String password1;
	
	@NotEmpty(message="비밀번호를 필수로 확인해야합니다.")
	private String password2;
	
	@NotEmpty(message="이메일은 필수로 입력해야합니다.")
	@Email
	private String email;
	
}
