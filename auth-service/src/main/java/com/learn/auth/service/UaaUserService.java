package com.learn.auth.service;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.dto.UaaUserDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaUserService extends BaseService<UaaUser> {

    /**
     * 保存 用户信息
     */
    UaaUserDto save(UaaUserDto uaaUserDto);

    /**
     * 更新 用户信息
     */
    UaaUserDto update(UaaUserDto uaaUserDto);

}
