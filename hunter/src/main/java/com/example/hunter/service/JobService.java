package com.example.hunter.service;

import com.example.hunter.bean.JobBean;

import java.util.List;

public interface JobService {

    public List<JobBean> findAll();

    public int save(JobBean jb);

    public void delete(int jobId);

    public int update(JobBean jb);
}
