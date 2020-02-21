package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.repository.UaaGroupUserRepository;
import com.learn.auth.service.UaaGroupUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-用户信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaGroupUserServiceImpl extends ServiceImpl<UaaGroupUserRepository, UaaGroupUser> implements UaaGroupUserService {

}
