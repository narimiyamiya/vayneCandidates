package com.example.hunter.dao;

import com.example.hunter.bean.AdminBean;
import com.example.hunter.model.AdminVin;
import com.example.hunter.model.AdminVout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    @Update("update admin set " +
            "name = #{name}," +
            "password = #{password} " +
            "where account = #{account}"
    )
    public int updateAdmin(AdminBean adminBean);
}
