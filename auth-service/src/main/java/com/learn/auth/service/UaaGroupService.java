package com.learn.auth.service;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.vo.UaaGroupTreeVo;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 组信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-04-25
 */
public interface UaaGroupService extends BaseService<UaaGroup> {

    /**
     * Description: 通过组织代码查询组树
     * date: 2020/1/1 19:57
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.vo.UaaGroupTreeDto>
     */
    List<UaaGroupTreeVo> selectGroupTree(String officeCode);

}
