package com.example.hunter;

import com.example.hunter.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HunterApplicationTests {
    @Autowired
    MemberService memberService;
    @Test
    void contextLoads() {
        System.out.println(memberService.findAll());
    }

}
