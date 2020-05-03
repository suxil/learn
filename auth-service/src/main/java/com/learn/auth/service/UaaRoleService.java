package com.learn.auth.service;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleDto;
import com.learn.auth.vo.UaaRoleTreeVo;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaRoleService extends BaseService<UaaRole> {

    /**
     * 保存 角色信息
     */
    UaaRoleDto save(UaaRoleDto uaaRoleDto);

    /**
     * 更新 角色信息
     */
    UaaRoleDto update(UaaRoleDto uaaRoleDto);

    /**
     * Description: 通过组织代码查询角色树
     * date: 2020/1/1 19:22
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.vo.UaaRoleTreeDto>
     */
    List<UaaRoleTreeVo> selectRoleTree(String officeCode);

}
