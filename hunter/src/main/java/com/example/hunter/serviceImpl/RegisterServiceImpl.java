package com.example.hunter.serviceImpl;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.dao.LoginMapper;
import com.example.hunter.model.LoginVin;
import com.example.hunter.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public int register(AdminBean adminbean){
      return   loginMapper.register(adminbean);
    };



}
