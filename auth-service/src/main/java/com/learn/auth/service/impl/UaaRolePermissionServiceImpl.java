package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaRolePermission;
import com.learn.auth.repository.UaaRolePermissionRepository;
import com.learn.auth.service.UaaRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaRolePermissionServiceImpl extends ServiceImpl<UaaRolePermissionRepository, UaaRolePermission> implements UaaRolePermissionService {

}
