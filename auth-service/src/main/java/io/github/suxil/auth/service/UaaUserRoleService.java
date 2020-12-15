package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaUserRole;
import io.github.suxil.auth.dto.UaaUserRoleDto;
import io.github.suxil.mybatis.service.BaseService;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaUserRoleService extends BaseService<UaaUserRole> {

    /**
     * 保存 角色信息
     */
    UaaUserRoleDto save(UaaUserRoleDto uaaUserRoleDto);

    /**
     * 更新 角色信息
     */
    UaaUserRoleDto update(UaaUserRoleDto uaaUserRoleDto);

}
