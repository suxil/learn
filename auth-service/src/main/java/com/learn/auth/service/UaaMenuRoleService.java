package com.learn.auth.service;

import com.learn.auth.domain.UaaMenuRole;
import com.learn.auth.dto.UaaMenuRoleDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 菜单-角色信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaMenuRoleService extends BaseService<UaaMenuRole> {

    /**
     * 保存 菜单-角色信息
     */
    UaaMenuRoleDto save(UaaMenuRoleDto uaaMenuRoleDto);

    /**
     * 更新 菜单-角色信息
     */
    UaaMenuRoleDto update(UaaMenuRoleDto uaaMenuRoleDto);

}
