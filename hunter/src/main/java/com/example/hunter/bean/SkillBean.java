package com.example.hunter.bean;

import java.util.Date;

public class SkillBean {
    private int skillId;
    private String skillName;
    private String describeSkill;
    private Date createTime;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescribeSkill() {
        return describeSkill;
    }

    public void setDescribeSkill(String describeSkill) {
        this.describeSkill = describeSkill;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
