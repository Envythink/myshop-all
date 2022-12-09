package com.kenbings.shop.shoprabbitmq.dao;

import com.kenbings.shop.shoprabbitmq.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用于查询后台用户与角色的自定义DAO
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}