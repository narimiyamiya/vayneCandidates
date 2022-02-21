package com.example.hunter.controller;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.LoginVin;
import com.example.hunter.model.LoginVout;
import com.example.hunter.service.impl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    RegisterService registerService;

    @RequestMapping("/register")
    public LoginVout loginVout(@RequestBody LoginVin loginVin){
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
            lvout.setIsSuccess("N");
            lvout.setErrorMsg("註冊失敗");
        }


        return lvout;

    }










}
