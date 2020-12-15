package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaGroupRole;
import io.github.suxil.auth.dto.UaaGroupRoleDto;
import io.github.suxil.mybatis.service.BaseService;

/**
 * <p>
 * 组-角色信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaGroupRoleService extends BaseService<UaaGroupRole> {

    /**
     * 保存 组-角色信息
     */
    UaaGroupRoleDto save(UaaGroupRoleDto uaaGroupRoleDto);

    /**
     * 更新 组-角色信息
     */
    UaaGroupRoleDto update(UaaGroupRoleDto uaaGroupRoleDto);

}
