package com.example.hunter.controller;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.constance.SystemConst;
import com.example.hunter.model.LoginVin;
import com.example.hunter.model.LoginVout;
import com.example.hunter.service.LoginService;
import com.example.hunter.service.RegisterService;
import com.example.hunter.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    RegisterService registerService;

    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    @ResponseBody
    public LoginVout register(@RequestBody LoginVin loginVin){
        LoginVout lvout = new LoginVout();
        AdminBean adminBean = new AdminBean();


        //新建一個加密類別的儲存空間
        DesUtil desUtil = new DesUtil();

        adminBean.setAccount(loginVin.getAccount());
        //將前端使用者輸入的密碼用加密方式存入資料庫中
        adminBean.setPassword(desUtil.encode(loginVin.getPassword(), SystemConst.pwdEncryptKey));
        System.out.println(adminBean);

        try {
            registerService.register(adminBean);
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

    @PostMapping ("/login")
    @ResponseBody
    public LoginVout login(@RequestBody LoginVin loginVin,  HttpServletRequest request){
        LoginVout lvout = new LoginVout();

        DesUtil desUtil = new DesUtil();

        AdminBean adminBean = new AdminBean();
        adminBean.setAccount(loginVin.getAccount());
        adminBean.setPassword(desUtil.encode(loginVin.getPassword(), SystemConst.pwdEncryptKey));

        try {
//            將前端輸入的帳號,Select到的資料放進List中,再跟資料庫比對
            List<AdminBean> adminBeanList = loginService.login(adminBean);

            if(adminBeanList == null || adminBeanList.size() == 0) {
                lvout.setIsSuccess("N");
                lvout.setErrorMsg("查無此帳號");

            }else if(adminBeanList.get(0).getPassword().equals(adminBean.getPassword())){
                HttpSession session = request.getSession();
                // OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
                session.setAttribute("loginOK",adminBean.getAccount());
                System.out.println(session.getAttribute("loginOK"));

                lvout.setIsSuccess("Y");
                lvout.setErrorMsg("登入成功");



            }else{
                lvout.setIsSuccess("N");
                lvout.setErrorMsg("密碼錯誤");
                }


            }
            catch (Exception exception){

                exception.printStackTrace();
                lvout.setIsSuccess("N");
                lvout.setErrorMsg("登入失敗");
            }


            return lvout;

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //銷毀session中的KV
        session.removeAttribute("loginOK");
        System.out.println(session.getAttribute("loginOK"));
        return "login.html";
    }







}
