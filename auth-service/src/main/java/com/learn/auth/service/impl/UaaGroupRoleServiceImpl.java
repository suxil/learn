package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.dto.UaaGroupRoleDto;
import com.learn.auth.converter.UaaGroupRoleConverter;
import com.learn.auth.repository.UaaGroupRoleRepository;
import com.learn.auth.service.UaaGroupRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaGroupRoleServiceImpl extends ServiceImpl<UaaGroupRoleRepository, UaaGroupRole> implements UaaGroupRoleService {

     @Override
     public UaaGroupRoleDto save(UaaGroupRoleDto uaaGroupRoleDto) {
         UaaGroupRole uaaGroupRole = UaaGroupRoleConverter.INSTANCE.convert(uaaGroupRoleDto);

         save(uaaGroupRole);

         return UaaGroupRoleConverter.INSTANCE.convertDto(uaaGroupRole);
     }

     @Override
     public UaaGroupRoleDto update(UaaGroupRoleDto uaaGroupRoleDto) {
         UaaGroupRole uaaGroupRole = UaaGroupRoleConverter.INSTANCE.convert(uaaGroupRoleDto);

         updateById(uaaGroupRole);

         return UaaGroupRoleConverter.INSTANCE.convertDto(uaaGroupRole);
     }

 }
