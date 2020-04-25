package com.learn.auth.service;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeTreeDto;
import com.learn.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 组织信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-04-25
 */
public interface UaaOfficeService extends BaseService<UaaOffice> {

    /***
     * Description: 通过组织代码查询组织树
     * date: 2020/1/1 11:33
     *
     * @author suxi
     * @version V1.0
     * @return java.util.List<com.learn.auth.dto.UaaOfficeTreeDto>
     */
    List<UaaOfficeTreeDto> selectOfficeTree();

}
