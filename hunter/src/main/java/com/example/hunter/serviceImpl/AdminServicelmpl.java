package com.example.hunter.serviceImpl;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.dao.AdminMapper;
import com.example.hunter.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicelmpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int updateAdmin(AdminBean adminBean){
        return adminMapper.updateAdmin(adminBean);
    }

}
