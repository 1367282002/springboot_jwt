package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.time.LocalDate;

@SpringBootApplication
@MapperScan("com.jwt.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(BootDemoApplication.class);
    }
}

