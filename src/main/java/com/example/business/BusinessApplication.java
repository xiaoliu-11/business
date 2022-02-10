package com.example.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.example.business.mapper"}) //扫描Mapper
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

}
