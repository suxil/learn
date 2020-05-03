package com.learn.auth.service;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionDto;
import com.learn.auth.vo.UaaPositionTreeVo;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaPositionService extends BaseService<UaaPosition> {

    /**
     * 保存 岗位信息
     */
    UaaPositionDto save(UaaPositionDto uaaPositionDto);

    /**
     * 更新 岗位信息
     */
    UaaPositionDto update(UaaPositionDto uaaPositionDto);

    /**
     * Description: 通过组织代码查询岗位树
     * date: 2020/1/1 19:59
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.vo.UaaPositionTreeDto>
     */
    List<UaaPositionTreeVo> selectPositionTree(String officeCode);

}
