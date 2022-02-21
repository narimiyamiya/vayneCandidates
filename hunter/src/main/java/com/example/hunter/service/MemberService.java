package com.example.hunter.service;

import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;

import java.util.List;

public interface MemberService {
    public List<memberBean> findAll();

    public List<memberBean> getMemberByPage(PagingBean pb);

    public int save(memberBean mb);

    public void delete(int memberId);

    public int update(memberBean mb);

}