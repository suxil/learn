package com.learn.auth.service;

import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionDto;
import com.learn.auth.vo.UaaPermissionTreeVo;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 权限信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaPermissionService extends BaseService<UaaPermission> {

    /**
     * 保存 权限信息
     */
    UaaPermissionDto save(UaaPermissionDto uaaPermissionDto);

    /**
     * 更新 权限信息
     */
    UaaPermissionDto update(UaaPermissionDto uaaPermissionDto);

    /**
     * Description: 通过组织代码查询权限树
     * date: 2020/1/1 20:04
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.vo.UaaPermissionTreeDto>
     */
    List<UaaPermissionTreeVo> selectPermissionTree(String officeCode);

}
