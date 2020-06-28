package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jwt.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {
        Integer i = 20;
        System.out.println(20);
        System.out.println("String");
        SpringApplication.run(BootDemoApplication.class);
    }
}

