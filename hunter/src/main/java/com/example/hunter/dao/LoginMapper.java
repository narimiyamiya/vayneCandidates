package com.example.hunter.dao;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.LoginVin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    @Insert("Insert into admin"+
            "(account,password)"+
            "values(#{account},#{password})"
            )
    public int register(AdminBean adminbean);

    @Select("select account,password from admin "+
            "where account = #{account}"
            )
    public List<AdminBean> login(AdminBean adminbean);
}
