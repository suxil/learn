package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaRolePermission;
import io.github.suxil.auth.dto.UaaRolePermissionDto;
import io.github.suxil.mybatis.service.BaseService;

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
