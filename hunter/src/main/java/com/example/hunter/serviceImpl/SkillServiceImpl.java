package com.example.hunter.serviceImpl;

import com.example.hunter.bean.PagingBean;
import com.example.hunter.bean.SkillBean;
import com.example.hunter.bean.memberBean;
import com.example.hunter.dao.SkillMapper;
import com.example.hunter.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillMapper skillMapper;

    @Override
    public List<SkillBean> findAll() {
        return skillMapper.findAll();
    }

    @Override
    public int save(SkillBean sb){
        return skillMapper.save(sb);

    }
    @Override
    public void delete(int skillId){
        skillMapper.delete(skillId);
    }

    @Override
    public  int update(SkillBean sb){
        return skillMapper.update(sb);
    }


}
