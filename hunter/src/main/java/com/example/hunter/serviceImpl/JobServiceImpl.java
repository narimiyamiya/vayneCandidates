package com.example.hunter.serviceImpl;

import com.example.hunter.bean.JobBean;
import com.example.hunter.dao.JobMapper;
import com.example.hunter.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public List<JobBean> findAll(){
        return jobMapper.findAll();
    }

    @Override
    public int save(JobBean jb) {
        return jobMapper.save(jb);
    }

    @Override
    public void delete(int jobId) {
        jobMapper.delete(jobId);
    }

    @Override
    public int update(JobBean jb) {
        return jobMapper.update(jb);
    }
}
