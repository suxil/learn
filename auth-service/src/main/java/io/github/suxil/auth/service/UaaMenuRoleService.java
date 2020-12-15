package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaMenuRole;
import io.github.suxil.auth.dto.UaaMenuRoleDto;
import io.github.suxil.mybatis.service.BaseService;

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
