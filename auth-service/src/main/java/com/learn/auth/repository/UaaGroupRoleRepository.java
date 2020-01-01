package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.domain.UaaRole;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 组-角色信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaGroupRoleRepository extends BaseRepository<UaaGroupRole> {

    /**
     * Description: 查询某个角色的组
     * date: 2020/1/1 20:53
     *
     * @author suxi
     * @version V1.0
     * @param roleId
     * @return java.util.List<com.learn.auth.domain.UaaGroup>
     */
    @Select("select g.* from uaa_group g where g.id in (select gr.group_id from uaa_group_role gr where gr.role_id = #{roleId})")
    List<UaaGroup> selectGroupByRoleId(String roleId);

    /**
     * Description: 查询某个组的角色
     * date: 2020/1/1 21:05
     *
     * @author suxi
     * @version V1.0
     * @param groupId
     * @return java.util.List<com.learn.auth.domain.UaaRole>
     */
    @Select("select r.* from uaa_role r where r.id in (select gr.role_id from uaa_group_role gr where gr.group_id = #{groupId})")
    List<UaaRole> selectRoleByGroupId(String groupId);
    
}
