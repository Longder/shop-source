package com.example.shopsource.dao;

import com.example.shopsource.entity.po.SysUser;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    /**
     * 根据登录名查询一个用户
     */
    @Select("SELECT * FROM SYS_USER WHERE login_name=#{loginName}")
    @ResultMap("com.example.shopsource.dao.SysUserDao.SysUserResultMap")
    SysUser getByLoginName(String loginName);
}
