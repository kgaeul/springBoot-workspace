package com.kh.springDB;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kh.springDB.mapper")
public class SpringDbOraclePreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbOraclePreApplication.class, args);
	}

}
