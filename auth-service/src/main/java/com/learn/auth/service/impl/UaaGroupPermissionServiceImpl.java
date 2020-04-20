package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaGroupPermission;
import com.learn.auth.repository.UaaGroupPermissionRepository;
import com.learn.auth.service.UaaGroupPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaGroupPermissionServiceImpl extends ServiceImpl<UaaGroupPermissionRepository, UaaGroupPermission> implements UaaGroupPermissionService {

}
