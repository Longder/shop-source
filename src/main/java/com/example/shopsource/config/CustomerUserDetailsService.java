package com.example.shopsource.config;

import com.example.shopsource.dao.SysUserDao;
import com.example.shopsource.dao.SysUserRoleDao;
import com.example.shopsource.entity.SysUser;
import com.example.shopsource.entity.SysUserRole;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


/**
 * 自定义的SpringSecurity用来做用户认证的service
 */
@Component
public class CustomerUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.getByLoginName(s);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new BadCredentialsException("用户名不正确");
        }
        //设置权限进去
        List<SysUserRole> roleList = sysUserRoleDao.listBySysUserId(sysUser.getId());
        sysUser.setRoles(roleList);
        return sysUser;
    }
}
