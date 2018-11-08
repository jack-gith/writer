package com.winterchen;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.winterchen.dao")
public class Springboot2MybatisDemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(Springboot2MybatisDemoApplication.class, args);

	}
}
