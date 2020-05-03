package com.learn.auth.service;

import com.learn.auth.domain.UaaGroupPermission;
import com.learn.auth.dto.UaaGroupPermissionDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 组-权限信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaGroupPermissionService extends BaseService<UaaGroupPermission> {

    /**
     * 保存 组-权限信息
     */
    UaaGroupPermissionDto save(UaaGroupPermissionDto uaaGroupPermissionDto);

    /**
     * 更新 组-权限信息
     */
    UaaGroupPermissionDto update(UaaGroupPermissionDto uaaGroupPermissionDto);

}
