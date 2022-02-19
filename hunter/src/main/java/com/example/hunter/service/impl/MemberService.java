package com.example.hunter.service.impl;

import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;

import java.util.List;

public interface MemberService {
    public List<memberBean> findAll();

    public List<memberBean> getMemberByPage(PagingBean pb);

    public memberBean save(memberBean mb);

    public void delete(int memberId);

}