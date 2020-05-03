package com.learn.auth.service;

import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.dto.UaaGroupUserDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 组-用户信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaGroupUserService extends BaseService<UaaGroupUser> {

    /**
     * 保存 组-用户信息
     */
    UaaGroupUserDto save(UaaGroupUserDto uaaGroupUserDto);

    /**
     * 更新 组-用户信息
     */
    UaaGroupUserDto update(UaaGroupUserDto uaaGroupUserDto);

}
