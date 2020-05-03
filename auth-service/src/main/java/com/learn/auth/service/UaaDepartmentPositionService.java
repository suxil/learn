package com.learn.auth.service;

import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.dto.UaaDepartmentPositionDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 部门-岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaDepartmentPositionService extends BaseService<UaaDepartmentPosition> {

    /**
     * 保存 部门-岗位信息
     */
    UaaDepartmentPositionDto save(UaaDepartmentPositionDto uaaDepartmentPositionDto);

    /**
     * 更新 部门-岗位信息
     */
    UaaDepartmentPositionDto update(UaaDepartmentPositionDto uaaDepartmentPositionDto);

}
