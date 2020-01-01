package com.learn.auth.repository;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.domain.UaaUserPosition;
import com.learn.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户-岗位信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaUserPositionRepository extends BaseRepository<UaaUserPosition> {

    /**
     * Description: 查询某个岗位下的用户
     * date: 2019/12/31 23:44
     *
     * @author suxi
     * @version V1.0
     * @param positionId
     * @return java.util.List<com.learn.auth.domain.UaaUser>
     */
    @Select("select u.* from uaa_user u where u.id in (select up.user_id from uaa_user_position up where up.position_id = #{positionId})")
    List<UaaUser> selectUserByPositionId(String positionId);

}
