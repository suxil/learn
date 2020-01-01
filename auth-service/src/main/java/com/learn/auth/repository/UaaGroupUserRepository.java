package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.domain.UaaUser;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 组-用户信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaGroupUserRepository extends BaseRepository<UaaGroupUser> {

    /**
     * Description: 查询某个组下的用户
     * date: 2019/12/31 23:32
     *
     * @author suxi
     * @version V1.0
     * @param groupId
     * @return java.util.List<com.learn.auth.domain.UaaUser>
     */
    @Select("select u.* from uaa_user u where u.id in (select gu.user_id from uaa_group_user gu where gu.group_id = #{groupId})")
    List<UaaUser> selectUserByGroupId(String groupId);

}
