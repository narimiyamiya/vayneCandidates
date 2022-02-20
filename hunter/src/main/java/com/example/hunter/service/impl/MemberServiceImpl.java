package com.example.hunter.service.impl;

import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;
import com.example.hunter.dao.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<memberBean> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public  List<memberBean> getMemberByPage(PagingBean pb){
        return memberMapper.getMemberByPage(pb);
    }

    @Override
    public int save(memberBean mb){
        return memberMapper.save(mb);

    }
    @Override
    public void delete(int memberId){
        memberMapper.delete(memberId);
    }

    @Override
    public  int update(memberBean mb){
        return memberMapper.update(mb);
    }




}