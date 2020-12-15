package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaPermission;
import io.github.suxil.auth.dto.UaaPermissionDto;
import io.github.suxil.auth.vo.UaaPermissionTreeVo;
import io.github.suxil.mybatis.service.BaseService;

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
     * @return java.util.List<io.github.suxil.auth.vo.UaaPermissionTreeDto>
     */
    List<UaaPermissionTreeVo> selectPermissionTree(String officeCode);

}
