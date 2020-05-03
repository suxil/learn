package com.learn.auth.service;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentDto;
import com.learn.auth.vo.UaaDepartmentTreeVo;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 部门信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaDepartmentService extends BaseService<UaaDepartment> {

    /**
     * 保存 部门信息
     */
    UaaDepartmentDto save(UaaDepartmentDto uaaDepartmentDto);

    /**
     * 更新 部门信息
     */
    UaaDepartmentDto update(UaaDepartmentDto uaaDepartmentDto);

    /**
     * Description: 通过组织代码查询岗位树
     * date: 2020/1/1 19:55
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.vo.UaaDepartmentTreeDto>
     */
    List<UaaDepartmentTreeVo> selectDepartmentTree(String officeCode);

}
