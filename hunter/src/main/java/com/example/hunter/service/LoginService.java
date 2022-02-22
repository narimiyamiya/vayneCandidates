package com.example.hunter.service;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.LoginVin;

import java.util.List;

public interface LoginService {
    public List<AdminBean> login(AdminBean adminBean);
}
