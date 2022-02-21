package com.example.hunter.dao;

import com.example.hunter.model.LoginVin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    @Insert("Insert into account"+
            "(account,password)"+
            "values(#{account},#{password})"
            )
    public int register(LoginVin loginVin);
}
