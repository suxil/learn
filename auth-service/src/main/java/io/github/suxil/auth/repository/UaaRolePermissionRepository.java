package io.github.suxil.auth.repository;

import io.github.suxil.auth.domain.UaaPermission;
import io.github.suxil.auth.domain.UaaRole;
import io.github.suxil.auth.domain.UaaRolePermission;
import io.github.suxil.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色-权限信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaRolePermissionRepository extends BaseRepository<UaaRolePermission> {

    /**
     * Description: 查询某个权限的角色
     * date: 2020/1/1 20:39
     *
     * @author suxi
     * @version V1.0
     * @param permissionId
     * @return java.util.List<io.github.suxil.auth.domain.UaaRole>
     */
    @Select("select r.* from uaa_role r where r.id in (select rp.role_id from uaa_role_permission rp where rp.permission_id = #{permissionId})")
    List<UaaRole> selectRoleByPermissionId(String permissionId);

    /**
     * Description: 查询某个角色的权限
     * date: 2020/1/1 20:50
     *
     * @author suxi
     * @version V1.0
     * @param roleId
     * @return java.util.List<io.github.suxil.auth.domain.UaaPermission>
     */
    @Select("select p.* from uaa_permission p where p.id in (select rp.permission_id from uaa_role_permission rp where rp.role_id = #{roleId})")
    List<UaaPermission> selectPermissionByRoleId(String roleId);

}
