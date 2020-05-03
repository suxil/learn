package com.learn.auth.service;

import com.learn.auth.domain.UaaMenuElementRole;
import com.learn.auth.dto.UaaMenuElementRoleDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 菜单菜单页面元素-角色息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaMenuElementRoleService extends BaseService<UaaMenuElementRole> {

    /**
     * 保存 菜单菜单页面元素-角色息
     */
    UaaMenuElementRoleDto save(UaaMenuElementRoleDto uaaMenuElementRoleDto);

    /**
     * 更新 菜单菜单页面元素-角色息
     */
    UaaMenuElementRoleDto update(UaaMenuElementRoleDto uaaMenuElementRoleDto);

}
