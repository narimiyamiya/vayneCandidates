package com.example.hunter.service.impl;

import com.example.hunter.dao.LoginMapper;
import com.example.hunter.model.LoginVin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    LoginMapper loginMapper;

    @Override
    public int register(LoginVin loginVin){
      return   loginMapper.register(loginVin);
    };

}
