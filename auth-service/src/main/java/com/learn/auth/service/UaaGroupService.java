package com.learn.auth.service;

import com.learn.auth.domain.UaaGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.dto.UaaGroupTreeDto;

import java.util.List;

/**
 * <p>
 * 组信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaGroupService extends IService<UaaGroup> {

    /**
     * Description: 通过组织代码查询组树
     * date: 2020/1/1 19:57
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaGroupTreeDto>
     */
    List<UaaGroupTreeDto> selectGroupTree(String officeCode);

}
