package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaMenuElementRole;
import io.github.suxil.auth.dto.UaaMenuElementRoleDto;
import io.github.suxil.mybatis.service.BaseService;

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
