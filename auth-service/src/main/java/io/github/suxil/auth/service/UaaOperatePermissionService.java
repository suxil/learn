package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaOperatePermission;
import io.github.suxil.auth.dto.UaaOperatePermissionDto;
import io.github.suxil.mybatis.service.BaseService;

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
