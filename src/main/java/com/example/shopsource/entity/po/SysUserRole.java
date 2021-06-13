package com.example.shopsource.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * 用户角色关联表，实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole implements GrantedAuthority {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long sysUserId;

    /**
     * 用户角色
     */
    private SysRole sysRole;

    @Override
    public String getAuthority() {
        return sysRole.getName();
    }
}
