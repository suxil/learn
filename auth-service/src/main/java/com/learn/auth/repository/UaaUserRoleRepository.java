package com.learn.auth.repository;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.learn.auth.domain.UaaUser;
import com.learn.auth.domain.UaaUserRole;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaUserRoleRepository extends BaseRepository<UaaUserRole> {

    /**
     * Description: 查询某个角色下的用户
     * date: 2019/12/31 23:31
     *
     * @author suxi
     * @version V1.0
     * @param roleId
     * @return java.util.List<com.learn.auth.domain.UaaUser>
     */
    @SqlParser
    @Select("select u.* from uaa_user u where u.id in (select ur.user_id from uaa_user_role ur where ur.role_id = #{roleId})")
    List<UaaUser> selectUserByRoleId(String roleId);

}
