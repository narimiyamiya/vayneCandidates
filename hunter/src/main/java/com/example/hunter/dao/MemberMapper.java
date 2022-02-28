package com.example.hunter.dao;

import com.example.hunter.bean.memberBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("Select * from member")
    public List<memberBean> findAll();

    @Select("Select * from member where mainSkill in (SELECT skillId from skills where skillName like concat('%',#{param},'%') ) " +
            "or secondSkill in (SELECT skillId FROM skills WHERE skillName LIKE concat('%',#{param},'%') ) " +
            "or name like concat('%',#{param},'%') ")
    public List<memberBean> findSpecificSkill(@Param("param") String param);

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

//    @Select("select * from member lIMIT #{someLimit} OFFSET #{offsetLimit}")
//    public List<memberBean> getMemberByPage(PagingBean pb);

    @Delete("delete from member where memberId = #{memberId}")
    public void delete(int memberId);

    @Update("update member set " +
            "name = #{name},"+
            "age = #{age},"+
            "gender = #{gender},"+
            "phone = #{phone},"+
            "email = #{email},"+
            "school = #{school},"+
            "major = #{major},"+
            "hopeWorkLoc = #{hopeWorkLoc},"+
            "salary = #{salary},"+
            "company = #{company},"+
            "mainSkill = #{mainSkill},"+
            "secondSkill = #{secondSkill},"+
            "role = #{role},"+
            "seniority = #{seniority},"+
            "hope = #{hope},"+
            "client = #{client},"+
            "updateTime = #{updateTime}"+
            "where memberId = #{memberId}")
    public int update(memberBean mb);



}
