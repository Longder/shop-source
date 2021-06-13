package com.example.shopsource.dao;

import com.example.shopsource.entity.po.SysUserRole;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleDao {
    /**
     * 根据用户id查询某个用户的所有角色
     */
    @Select("SELECT * FROM SYS_USER_ROLE WHERE sys_user_id = #{sysUserId}")
    @ResultMap("com.example.shopsource.dao.SysUserRoleDao.SysUserRoleResultMap")
    List<SysUserRole> listBySysUserId(Long sysUserId);
}
