package com.example.hunter.controller;

import com.example.hunter.model.AddMemberInfoVin;
import com.example.hunter.model.AddMemberVout;
import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;
import com.example.hunter.model.DeleteMemberVin;
import com.example.hunter.model.DeleteMemberVout;
import com.example.hunter.service.impl.MemberService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/findAll")
    public List<memberBean> findAll() {
        return memberService.findAll();
    }

    @RequestMapping("/addCandidate")
    public AddMemberVout addMemberVout(@RequestBody AddMemberInfoVin addMemberInfoVin) {
        AddMemberVout amv = new AddMemberVout();
        memberBean mb = new memberBean();
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        mb.setName(addMemberInfoVin.getName());
        mb.setGender(addMemberInfoVin.getGender());
        mb.setAge(addMemberInfoVin.getAge());
        mb.setPhone(addMemberInfoVin.getPhone());
        mb.setEmail(addMemberInfoVin.getEmail());
        mb.setSchool(addMemberInfoVin.getSchool());
        mb.setMajor(addMemberInfoVin.getMajor());
        mb.setCompany(addMemberInfoVin.getCompany());
        mb.setSalary(addMemberInfoVin.getSalary());
        mb.setMainSkill(addMemberInfoVin.getMainSkill());
        mb.setSecondSkill(addMemberInfoVin.getSecondSkill());
        mb.setRole(addMemberInfoVin.getRole());
        mb.setSeniority(addMemberInfoVin.getSeniority());
        mb.setHopeWorkLoc(addMemberInfoVin.getHopeWorkLoc());
        mb.setHope(addMemberInfoVin.getHope());
        mb.setClient(addMemberInfoVin.getClient());
        mb.setCreateTime(ts);
        mb.setUpdateTime(ts);
//        memberService.save(mb);
        System.out.println(mb);

        try {
            memberService.save(mb);
            amv.setIsSuccess("Y");
            amv.setErrorMsg("新增求職者成功");
        }
        catch (Exception exception)
        {
            amv.setIsSuccess("N");
            amv.setErrorMsg("新增求職者失敗");
        }


        return amv;
    }

    @RequestMapping("/getMemberByPage")
    public List<memberBean> getMemberByPage() {
        PagingBean pb = new PagingBean();
        pb.setSomeLimit(10);
        pb.setOffsetLimit(0);
        return memberService.getMemberByPage(pb);
    }

    @RequestMapping("/deleteCandidate")
    public DeleteMemberVout deleteMemberVout(@RequestBody DeleteMemberVin deleteMemberVin) {
        DeleteMemberVout delVout = new DeleteMemberVout();
        try {
            memberService.delete(deleteMemberVin.getMemberId());
            delVout.setIsSuccess("Y");
            delVout.setErrorMsg("刪除求職者成功");
        }
        catch (Exception exception)
        {
            delVout.setIsSuccess("N");
            delVout.setErrorMsg("刪除求職者失敗");
        }
        return delVout;
        }

    }

