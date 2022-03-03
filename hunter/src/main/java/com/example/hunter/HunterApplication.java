package com.example.hunter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan("com.example.hunter.dao")
public class HunterApplication  extends SpringBootServletInitializer{


    public static void main(String[] args) {
        SpringApplication.run(HunterApplication.class, args);


    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HunterApplication.class);
    }

}
