package com.example.hunter.dao;

import com.example.hunter.bean.SkillBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkillMapper {

    @Select("Select * from skills")
    public List<SkillBean> findAll();

    @Options(useGeneratedKeys = true, keyProperty = "skillId")
    @Insert({"insert into skills"+
            "(skillName,describeSkill,createTime)"+
            "values"+
            "(#{skillName},#{describeSkill},#{createTime})" })
    public int save(SkillBean sb);

    @Delete("delete from skills where skillId = #{skillId}")
    public void delete(int skillId);

    @Update("update skills set " +
            "skillName = #{skillName},"+
            "describeSkill = #{describeSkill}"+
//            "createTime = #{createTime},"+
            "where skillId = #{skillId}")
    public int update(SkillBean sb);



}
