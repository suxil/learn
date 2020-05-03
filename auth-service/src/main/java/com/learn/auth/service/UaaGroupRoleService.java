package com.learn.auth.service;

import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.dto.UaaGroupRoleDto;
import com.learn.mybatis.service.BaseService;

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
