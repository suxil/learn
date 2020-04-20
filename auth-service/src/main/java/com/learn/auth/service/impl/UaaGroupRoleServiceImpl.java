package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.repository.UaaGroupRoleRepository;
import com.learn.auth.service.UaaGroupRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaGroupRoleServiceImpl extends ServiceImpl<UaaGroupRoleRepository, UaaGroupRole> implements UaaGroupRoleService {

}
