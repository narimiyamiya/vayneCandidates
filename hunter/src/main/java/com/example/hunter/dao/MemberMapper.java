package com.example.hunter.dao;

import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.memberBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("Select * from member")
    public List<memberBean> findAll();

    @Options(useGeneratedKeys = true, keyProperty = "memberId")
    @Insert({"insert into member"+
            "(name,age,gender,phone,email,school," +
            "major,hopeWorkLoc,salary,company,mainSkill,secondSkill,role,"+
            "seniority,hope,client,createTime,updateTime)"+
            "values"+
            "(#{name},#{age},#{gender},#{phone},#{email},#{school}," +
            "#{major},#{hopeWorkLoc},#{salary},#{company},#{mainSkill},#{secondSkill},#{role},"+
            "#{seniority},#{hope},#{client},#{createTime},#{updateTime})"  })
    public int save(memberBean mb);

    @Select("select * from member lIMIT #{someLimit} OFFSET #{offsetLimit}")
    public List<memberBean> getMemberByPage(PagingBean pb);

    @Delete("delete from member where memberId = #{memberId}")
    public void delete(int memberId);


}
