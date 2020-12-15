package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaRole;
import io.github.suxil.auth.dto.UaaRoleDto;
import io.github.suxil.auth.vo.UaaRoleTreeVo;
import io.github.suxil.mybatis.service.BaseService;

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
     * @return java.util.List<io.github.suxil.auth.vo.UaaRoleTreeDto>
     */
    List<UaaRoleTreeVo> selectRoleTree(String officeCode);

}
