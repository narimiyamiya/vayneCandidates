package com.example.hunter.controller;

import com.example.hunter.model.*;
import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;
import com.example.hunter.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/findSpecificSkill")
    public List<memberBean> findSpecificSkill(@RequestBody String param){
        return memberService.findSpecificSkill(param);
    };

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
        mb.setLanguage(addMemberInfoVin.getLanguage());
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

    @RequestMapping("/updateCandidate")
    public UpdateMemberVout updateMemberVout(@RequestBody UpdateMemberVin updateMemberVin){
        UpdateMemberVout umv = new UpdateMemberVout();
        memberBean mb = new memberBean();
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        mb.setMemberId(updateMemberVin.getMemberId());
        mb.setName(updateMemberVin.getName());
        mb.setGender(updateMemberVin.getGender());
        mb.setAge(updateMemberVin.getAge());
        mb.setPhone(updateMemberVin.getPhone());
        mb.setEmail(updateMemberVin.getEmail());
        mb.setSchool(updateMemberVin.getSchool());
        mb.setMajor(updateMemberVin.getMajor());
        mb.setCompany(updateMemberVin.getCompany());
        mb.setSalary(updateMemberVin.getSalary());
        mb.setMainSkill(updateMemberVin.getMainSkill());
        mb.setSecondSkill(updateMemberVin.getSecondSkill());
        mb.setRole(updateMemberVin.getRole());
        mb.setLanguage(updateMemberVin.getLanguage());
        mb.setSeniority(updateMemberVin.getSeniority());
        mb.setHopeWorkLoc(updateMemberVin.getHopeWorkLoc());
        mb.setHope(updateMemberVin.getHope());
        mb.setClient(updateMemberVin.getClient());
//        mb.setCreateTime(ts);
        mb.setUpdateTime(ts);
//        memberService.save(mb);
        System.out.println(mb);

        try {
            memberService.update(mb);
            umv.setIsSuccess("Y");
            umv.setErrorMsg("更新求職者資訊成功");
        }
        catch (Exception exception)
        {
            umv.setIsSuccess("N");
            umv.setErrorMsg("更新求職者資訊失敗");
            exception.printStackTrace();
        }


        return umv;
    }







}

