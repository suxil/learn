package com.learn.auth.service;

import com.learn.auth.domain.UaaUserLoginLog;
import com.learn.auth.dto.UaaUserLoginLogDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 用户登录日志 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaUserLoginLogService extends BaseService<UaaUserLoginLog> {

    /**
     * 保存 用户登录日志
     */
    UaaUserLoginLogDto save(UaaUserLoginLogDto uaaUserLoginLogDto);

    /**
     * 更新 用户登录日志
     */
    UaaUserLoginLogDto update(UaaUserLoginLogDto uaaUserLoginLogDto);

}
