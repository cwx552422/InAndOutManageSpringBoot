package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.java.dao"})
@EnableScheduling //开启定时计划
public class InAndOutManage{
	public static void main(String[] args) {
		SpringApplication.run(InAndOutManage.class, args);
	}
}
