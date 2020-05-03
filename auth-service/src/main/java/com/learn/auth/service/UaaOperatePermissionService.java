package com.learn.auth.service;

import com.learn.auth.domain.UaaOperatePermission;
import com.learn.auth.dto.UaaOperatePermissionDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 操作-权限息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaOperatePermissionService extends BaseService<UaaOperatePermission> {

    /**
     * 保存 操作-权限息
     */
    UaaOperatePermissionDto save(UaaOperatePermissionDto uaaOperatePermissionDto);

    /**
     * 更新 操作-权限息
     */
    UaaOperatePermissionDto update(UaaOperatePermissionDto uaaOperatePermissionDto);

}
