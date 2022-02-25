package com.example.hunter.model;

import java.util.Date;

public class DeleteJobVin {

    private int jobId;
    private String jobName;
    private String describeJob;
    private Date createTime;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescribeJob() {
        return describeJob;
    }

    public void setDescribeJob(String describeJob) {
        this.describeJob = describeJob;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeleteJobVin{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", describeJob='" + describeJob + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
