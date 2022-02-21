package com.example.hunter.controller;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.LoginVin;
import com.example.hunter.model.LoginVout;
import com.example.hunter.service.LoginService;
import com.example.hunter.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    RegisterService registerService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/register")
    public LoginVout register(@RequestBody LoginVin loginVin){
        LoginVout lvout = new LoginVout();
        AdminBean adminBean = new AdminBean();
        adminBean.setAccount(loginVin.getAccount());
        adminBean.setPassword(loginVin.getPassword());
        System.out.println(adminBean);

        try {
            registerService.register(loginVin);
            lvout.setIsSuccess("Y");
            lvout.setErrorMsg("註冊成功");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            lvout.setIsSuccess("N");
            lvout.setErrorMsg("註冊失敗");
        }


        return lvout;

    }

    @RequestMapping("/login")
    public LoginVout login(@RequestBody LoginVin loginVin,  HttpServletRequest request){
        LoginVout lvout = new LoginVout();

        try {
//            將前端輸入的帳號,Select到的資料放進List中,再跟資料庫比對
            List<AdminBean> adminBeanList = loginService.login(loginVin);

            if(adminBeanList == null || adminBeanList.size() == 0) {
                lvout.setIsSuccess("N");
                lvout.setErrorMsg("查無此帳號");
            }else if(adminBeanList.get(0).getPassword().equals(loginVin.getPassword())){
                lvout.setIsSuccess("Y");
                lvout.setErrorMsg("登入成功");

            }else{
                lvout.setIsSuccess("N");
                lvout.setErrorMsg("密碼錯誤");
            }


        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            lvout.setIsSuccess("N");
            lvout.setErrorMsg("登入失敗");
        }


        return lvout;

    }









}
