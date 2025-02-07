package com.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: tina.huanght
 * @Date: 16/01/25 16:39
 */
@SpringBootApplication
@MapperScan("com.portal.dao")
public class MMallAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMallAPIApplication.class, args);
        System.out.println("this is test: mmall");
    }
}

