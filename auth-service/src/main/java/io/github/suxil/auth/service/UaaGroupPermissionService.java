package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaGroupPermission;
import io.github.suxil.auth.dto.UaaGroupPermissionDto;
import io.github.suxil.mybatis.service.BaseService;

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
