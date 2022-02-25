package com.example.hunter.controller;

import com.example.hunter.bean.JobBean;
import com.example.hunter.bean.SkillBean;
import com.example.hunter.model.*;
import com.example.hunter.service.JobService;
import com.example.hunter.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @RequestMapping("/findAllJobs")
    public List<JobBean> findAll() {
        return jobService.findAll();
    }

    @RequestMapping("/updateJobs")
    public CommonResultVout commonResultVout(@RequestBody UpdateJobVin updateJobVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        JobBean jb = new JobBean();
        Date date = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        jb.setJobId(updateJobVin.getJobId());
        jb.setJobName(updateJobVin.getJobName());
        jb.setDescribeJob(updateJobVin.getDescribeJob());


        try {
            jobService.update(jb);
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("修改職務成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("修改職務失敗");
            exception.printStackTrace();
        }


        return commonResultVout;



    }

    @RequestMapping("/addJobs")
    public CommonResultVout commonResultVout(@RequestBody AddJobVin addJobVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        JobBean jb = new JobBean();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        jb.setJobName(addJobVin.getJobName());
        jb.setDescribeJob(addJobVin.getDescribeJob());
        jb.setCreateTime(ts);


        try {
            jobService.save(jb);
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("新增職務成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("新增職務失敗");
            exception.printStackTrace();
        }


        return commonResultVout;

    }
    @RequestMapping("/deleteJobs")
    public  CommonResultVout commonResultVout(@RequestBody DeleteJobVin deleteJobVin){
        CommonResultVout commonResultVout = new CommonResultVout();
        try {
            jobService.delete(deleteJobVin.getJobId());
            commonResultVout.setIsSuccess("Y");
            commonResultVout.setErrorMsg("刪除職務成功");
        }
        catch (Exception exception)
        {
            commonResultVout.setIsSuccess("N");
            commonResultVout.setErrorMsg("刪除職務失敗");
        }
        return commonResultVout;
    }





}
