package com.learn.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.domain.UaaPosition;
import com.learn.auth.vo.UaaPositionTreeVo;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaPositionService extends IService<UaaPosition> {

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
