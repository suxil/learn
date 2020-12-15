package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaDepartmentPosition;
import io.github.suxil.auth.dto.UaaDepartmentPositionDto;
import io.github.suxil.mybatis.service.BaseService;

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
