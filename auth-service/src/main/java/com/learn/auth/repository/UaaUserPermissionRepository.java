package com.learn.auth.repository;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.domain.UaaUserPermission;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户-权限信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaUserPermissionRepository extends BaseRepository<UaaUserPermission> {

    /**
     * Description: 查询某个权限下的用户
     * date: 2019/12/31 23:32
     *
     * @author suxi
     * @version V1.0
     * @param permissionId
     * @return java.util.List<com.learn.auth.domain.UaaUser>
     */
    @Select("select u.* from uaa_user u where u.id in (select up.user_id from uaa_user_permission up where up.permission_id = #{permissionId})")
    List<UaaUser> selectUserByPermissionId(String permissionId);

}
