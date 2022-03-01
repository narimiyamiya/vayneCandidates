package com.example.hunter.controller;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.constance.SystemConst;
import com.example.hunter.model.AdminVin;
import com.example.hunter.model.AdminVout;
import com.example.hunter.model.CommonResultVout;
import com.example.hunter.service.AdminService;
import com.example.hunter.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/initAdmin")
    public AdminVout initAdmin(HttpSession session){

        AdminVout adminVout = new AdminVout();
        AdminBean adminBean = new AdminBean();
        adminBean = (AdminBean) session.getAttribute("loginOK");
        adminVout.setName(adminBean.getName());
        adminVout.setAccount(adminBean.getAccount());



        return adminVout;
    }

    @PostMapping("/updateAdmin")
    public CommonResultVout update(@RequestBody AdminVin adminVin ,HttpSession session){
        CommonResultVout commonResultVout = new CommonResultVout();
        AdminBean ab = new AdminBean();
        DesUtil desUtil = new DesUtil();

        try {
            ab  = (AdminBean) session.getAttribute("loginOK");
            ab.setName(adminVin.getName());
            ab.setPassword(desUtil.encode(adminVin.getPassword(), SystemConst.pwdEncryptKey));
            adminService.updateAdmin(ab);
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("修改會員資料成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("修改會員資料失敗");
            exception.printStackTrace();
        }

        return commonResultVout;
    }


}
