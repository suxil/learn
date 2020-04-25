package com.learn.auth.service;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionTreeDto;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-04-25
 */
public interface UaaPositionService extends BaseService<UaaPosition> {

    /**
     * Description: 通过组织代码查询岗位树
     * date: 2020/1/1 19:59
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaPositionTreeDto>
     */
    List<UaaPositionTreeDto> selectPositionTree(String officeCode);

}
