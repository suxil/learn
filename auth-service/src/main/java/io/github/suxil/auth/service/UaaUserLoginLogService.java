package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaUserLoginLog;
import io.github.suxil.auth.dto.UaaUserLoginLogDto;
import io.github.suxil.mybatis.service.BaseService;

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
