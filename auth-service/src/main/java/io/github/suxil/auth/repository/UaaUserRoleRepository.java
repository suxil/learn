package io.github.suxil.auth.repository;

import io.github.suxil.auth.domain.UaaRole;
import io.github.suxil.auth.domain.UaaUser;
import io.github.suxil.auth.domain.UaaUserRole;
import io.github.suxil.mybatis.repository.BaseRepository;
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
     * Description: 查询某个角色的用户
     * date: 2019/12/31 23:31
     *
     * @author suxi
     * @version V1.0
     * @param roleId
     * @return java.util.List<io.github.suxil.auth.domain.UaaUser>
     */
    @Select("select u.* from uaa_user u where u.id in (select ur.user_id from uaa_user_role ur where ur.role_id = #{roleId})")
    List<UaaUser> selectUserByRoleId(String roleId);

    /**
     * Description: 查询某个用户的角色
     * date: 2020/1/1 20:32
     *
     * @author suxi
     * @version V1.0
     * @param userId
     * @return java.util.List<io.github.suxil.auth.domain.UaaRole>
     */
    @Select("select r.* from uaa_role r where r.id in (select ur.role_id from uaa_user_role ur where ur.user_id = #{userId})")
    List<UaaRole> selectRoleByUserId(String userId);

}
