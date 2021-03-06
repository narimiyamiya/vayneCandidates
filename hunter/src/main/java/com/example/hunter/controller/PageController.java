package com.example.hunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("loginOK"));
        if(session.getAttribute("loginOK")!=null){

            return "index.html";

        }else{

            return "login.html";

        }

    }

    @RequestMapping("/header")
    public  String header(){
        return "header.html";
    }

    @RequestMapping("/loginPage")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/adminPage")
    public String admin(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("loginOK"));
        if(session.getAttribute("loginOK")!=null){

            return "admin.html";

        }else{

            return "login.html";

        }
    }

    @RequestMapping("/skills")
    public String skills(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("loginOK"));
        if(session.getAttribute("loginOK")!=null){

            return "skillsManage.html";

        }else{

            return "login.html";

        }

    }

    @RequestMapping("/jobs")
    public String jobs(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("loginOK"));
        if(session.getAttribute("loginOK")!=null){

            return "jobManage.html";

        }else{

            return "login.html";

        }

    }
}
