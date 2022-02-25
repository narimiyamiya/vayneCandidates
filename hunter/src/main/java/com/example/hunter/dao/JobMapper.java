package com.example.hunter.dao;

import com.example.hunter.bean.JobBean;
import com.example.hunter.bean.SkillBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobMapper {

    @Select("Select * from jobs")
    public List<JobBean> findAll();

    @Options(useGeneratedKeys = true, keyProperty = "jobId")
    @Insert({"insert into jobs"+
            "(jobName,describeJob,createTime)"+
            "values"+
            "(#{jobName},#{describeJob},#{createTime})" })
    public int save(JobBean jb);

    @Delete("delete from jobs where jobId = #{jobId}")
    public void delete(int skillId);

    @Update("update jobs set " +
            "jobName = #{jobName},"+
            "describeJob = #{describeJob}"+
            "where jobId = #{jobId}")
    public int update(JobBean jb);


}
