package com.learn.auth.service;

import com.learn.auth.domain.UaaUserPermission;
import com.learn.auth.dto.UaaUserPermissionDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 用户-权限信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaUserPermissionService extends BaseService<UaaUserPermission> {

    /**
     * 保存 用户-权限信息
     */
    UaaUserPermissionDto save(UaaUserPermissionDto uaaUserPermissionDto);

    /**
     * 更新 用户-权限信息
     */
    UaaUserPermissionDto update(UaaUserPermissionDto uaaUserPermissionDto);

}
