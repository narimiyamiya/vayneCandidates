package com.example.hunter;

import com.example.hunter.service.impl.MemberService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
@MapperScan("com.example.hunter.dao")
public class HunterApplication {


    public static void main(String[] args) {
        SpringApplication.run(HunterApplication.class, args);


    }


}
