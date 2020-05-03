package com.learn.auth.service;

import com.learn.auth.domain.UaaOperate;
import com.learn.auth.dto.UaaOperateDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 操作信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaOperateService extends BaseService<UaaOperate> {

    /**
     * 保存 操作信息
     */
    UaaOperateDto save(UaaOperateDto uaaOperateDto);

    /**
     * 更新 操作信息
     */
    UaaOperateDto update(UaaOperateDto uaaOperateDto);

}
