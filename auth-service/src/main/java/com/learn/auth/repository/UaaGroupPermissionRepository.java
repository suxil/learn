package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.domain.UaaGroupPermission;
import com.learn.auth.domain.UaaPermission;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 组-权限信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaGroupPermissionRepository extends BaseRepository<UaaGroupPermission> {

    /**
     * Description: 查询某个权限的组
     * date: 2020/1/1 20:50
     *
     * @author suxi
     * @version V1.0
     * @param permissionId
     * @return java.util.List<com.learn.auth.domain.UaaGroup>
     */
    @Select("select g.* from uaa_group g where g.id in (select gp.group_id from uaa_group_permission gp where gp.permission_id = #{permissionId})")
    List<UaaGroup> selectGroupByPermissionId(String permissionId);

    /**
     * Description: 查询某个组的权限
     * date: 2020/1/1 20:53
     *
     * @author suxi
     * @version V1.0
     * @param groupId
     * @return java.util.List<com.learn.auth.domain.UaaPermission>
     */
    @Select("select p.* from uaa_permission p where p.id in (select gp.permission_id from uaa_group_permission gp where gp.group_id = #{groupId})")
    List<UaaPermission> selectPermissionByGroupId(String groupId);

}
