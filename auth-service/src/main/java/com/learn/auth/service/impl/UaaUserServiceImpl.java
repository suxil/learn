package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.mapper.UaaUserMapper;
import com.learn.auth.service.IUaaUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Service
public class UaaUserServiceImpl extends ServiceImpl<UaaUserMapper, UaaUser> implements IUaaUserService {

}
