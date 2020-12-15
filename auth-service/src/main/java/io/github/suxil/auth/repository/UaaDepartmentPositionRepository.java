package io.github.suxil.auth.repository;

import io.github.suxil.auth.domain.UaaDepartment;
import io.github.suxil.auth.domain.UaaDepartmentPosition;
import io.github.suxil.auth.domain.UaaPosition;
import io.github.suxil.mybatis.repository.BaseRepository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门-岗位信息 Mapper 接口
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaDepartmentPositionRepository extends BaseRepository<UaaDepartmentPosition> {

    /**
     * Description: 查询某个岗位的部门
     * date: 2020/1/1 20:45
     *
     * @author suxi
     * @version V1.0
     * @param positionId
     * @return java.util.List<io.github.suxil.auth.domain.UaaDepartment>
     */
    @Select("select d.* from uaa_department d where d.id in (select dp.department_id from uaa_department_position dp where dp.position_id = #{positionId})")
    List<UaaDepartment> selectDepartmentByPositionId(String positionId);

    /**
     * Description: 查询某个部门的岗位
     * date: 2020/1/1 20:50
     *
     * @author suxi
     * @version V1.0
     * @param departmentId
     * @return java.util.List<io.github.suxil.auth.domain.UaaPosition>
     */
    @Select("select p.* from uaa_position p where p.id in (select dp.position_id from uaa_department_position dp where dp.department_id = #{departmentId})")
    List<UaaPosition> selectPositionByDepartmentId(String departmentId);

}
