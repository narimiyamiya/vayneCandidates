package com.example.hunter.serviceImpl;

import com.example.hunter.bean.memberBean;
import com.example.hunter.dao.MemberMapper;
import com.example.hunter.service.MemberService;
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
    public  List<memberBean> findSpecificSkill(String param) {
        List<memberBean> memberBeans = memberMapper.findSpecificSkill(param);
        return memberBeans;
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
