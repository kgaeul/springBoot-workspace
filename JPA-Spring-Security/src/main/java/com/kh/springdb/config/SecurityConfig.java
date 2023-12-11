package com.kh.springdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration//스프링 시큐리티 설정을 의미하는 어노테이션
@EnableWebSecurity//모든 url이 스프링 시큐리티의 제어를 받도록 만든 어노테이션
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests
		.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		//("/**"))모든 폴더 다 오케이!!
		
		.formLogin((formLogin)->formLogin.loginPage("/user/login").defaultSuccessUrl("/"))
		
		
		.logout((logout)->logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/").invalidateHttpSession(true))
		;
		return http.build();
		
		
		
		}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration a) throws Exception {
		return a.getAuthenticationManager();
	}
	//비밀번호 변경 시 어떤 식으로 암호처리를 할 지 설정
		@Bean
		PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
			//BCryptPasswordEncoder형식으로 저장
	}
}
