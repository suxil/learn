package com.learn.auth.service;

import com.learn.auth.domain.UaaRolePermission;
import com.learn.auth.dto.UaaRolePermissionDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 角色-权限信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaRolePermissionService extends BaseService<UaaRolePermission> {

    /**
     * 保存 角色-权限信息
     */
    UaaRolePermissionDto save(UaaRolePermissionDto uaaRolePermissionDto);

    /**
     * 更新 角色-权限信息
     */
    UaaRolePermissionDto update(UaaRolePermissionDto uaaRolePermissionDto);

}
