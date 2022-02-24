package com.example.hunter.service;

import com.example.hunter.bean.SkillBean;
import com.example.hunter.bean.memberBean;

import java.util.List;

public interface SkillService {
    public List<SkillBean> findAll();

    public int save(SkillBean sb);

    public void delete(int skillId);

    public int update(SkillBean sb);

}