package com.kenbings.shop.shopspringsecurityjwt.service;

import com.kenbings.shop.shopspringsecurityjwt.mbg.model.UmsAdmin;
import com.kenbings.shop.shopspringsecurityjwt.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 */
public interface UmsAdminService {
    /**
     * 根据用户名查询后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 后台管理员注册
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 后台管理员登录
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取指定后台管理员的所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}