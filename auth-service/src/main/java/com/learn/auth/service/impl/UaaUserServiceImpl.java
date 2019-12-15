package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.repository.UaaUserRepository;
import com.learn.auth.service.UaaUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-15
 */
@Service
public class UaaUserServiceImpl extends ServiceImpl<UaaUserRepository, UaaUser> implements UaaUserService {

}
