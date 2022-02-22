package com.example.hunter.serviceImpl;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.dao.LoginMapper;
import com.example.hunter.model.LoginVin;
import com.example.hunter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginSetviceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    public List<AdminBean> login(AdminBean adminBean){
        return loginMapper.login(adminBean);
    }
}
