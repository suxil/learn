package com.learn.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionTreeDto;

import java.util.List;

/**
 * <p>
 * 权限信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaPermissionService extends IService<UaaPermission> {

    /**
     * Description: 通过组织代码查询权限树
     * date: 2020/1/1 20:04
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaPermissionTreeDto>
     */
    List<UaaPermissionTreeDto> selectPermissionTree(String officeCode);

}
