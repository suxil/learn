package com.learn.auth.service;

import com.learn.auth.domain.UaaUserRole;
import com.learn.auth.dto.UaaUserRoleDto;
import com.learn.mybatis.service.BaseService;

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
