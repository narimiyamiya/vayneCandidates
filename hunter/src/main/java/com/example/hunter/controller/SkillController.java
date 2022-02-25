package com.example.hunter.controller;

import com.example.hunter.bean.SkillBean;
import com.example.hunter.model.AddSkillVin;
import com.example.hunter.model.CommonResultVout;
import com.example.hunter.model.DeleteSkillVin;
import com.example.hunter.model.UpdateSkillVin;
import com.example.hunter.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class SkillController {

    @Autowired
    SkillService skillService;

    @RequestMapping("/findAllSkill")
    public List<SkillBean> findAll() {
        return skillService.findAll();
    }

    @RequestMapping("/updateSkills")
    public CommonResultVout commonResultVout(@RequestBody UpdateSkillVin updateSkillVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        SkillBean sb = new SkillBean();
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        sb.setSkillId(updateSkillVin.getSkillId());
        sb.setSkillName(updateSkillVin.getSkillName());
        sb.setDescribeSkill(updateSkillVin.getDescribeSkill());


        try {
            var x=skillService.update(sb);
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("修改技能成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("修改技能失敗");
            exception.printStackTrace();
        }


        return commonResultVout;



    }

    @RequestMapping("/addSkills")
    public CommonResultVout commonResultVout(@RequestBody AddSkillVin addSkillVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        SkillBean sb = new SkillBean();
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        sb.setSkillName(addSkillVin.getSkillName());
        sb.setDescribeSkill(addSkillVin.getDescribeSkill());
        sb.setCreateTime(ts);


        try {
            skillService.save(sb);
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("新增技能成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("新增技能失敗");
            exception.printStackTrace();
        }


        return commonResultVout;

    }
    @RequestMapping("/deleteSkills")
    public  CommonResultVout commonResultVout(@RequestBody DeleteSkillVin deleteSkillVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        try {
            skillService.delete(deleteSkillVin.getSkillId());
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("刪除求職者成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("刪除求職者失敗");
        }
        return commonResultVout;
    }




}

