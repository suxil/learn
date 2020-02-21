package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaUserLoginLog;
import com.learn.auth.repository.UaaUserLoginLogRepository;
import com.learn.auth.service.UaaUserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录日志 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaUserLoginLogServiceImpl extends ServiceImpl<UaaUserLoginLogRepository, UaaUserLoginLog> implements UaaUserLoginLogService {

}
