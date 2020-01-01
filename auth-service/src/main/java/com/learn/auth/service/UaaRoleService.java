package com.learn.auth.service;

import com.learn.auth.domain.UaaRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.dto.UaaRoleTreeDto;

import java.util.List;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaRoleService extends IService<UaaRole> {

    /**
     * Description: 通过组织代码查询角色树
     * date: 2020/1/1 19:22
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaRoleTreeDto>
     */
    List<UaaRoleTreeDto> selectRoleTree(String officeCode);

}
