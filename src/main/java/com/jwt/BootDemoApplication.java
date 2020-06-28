package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.time.LocalDate;

@SpringBootApplication
@MapperScan("com.jwt.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {
        Integer i = 20;
        System.out.println(20);
        System.out.println("String");
        LocalDate l = LocalDate.now();
        System.out.println(l);
        SpringApplication.run(BootDemoApplication.class);
    }
}

