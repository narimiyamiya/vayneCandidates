package com.example.hunter.dao;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.LoginVin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    @Insert("Insert into account"+
            "(account,password)"+
            "values(#{account},#{password})"
            )
    public int register(LoginVin loginVin);

    @Select("select account,password from admin "+
            "where account = #{account}"
            )
    public List<AdminBean> login(LoginVin loginVin);
}
