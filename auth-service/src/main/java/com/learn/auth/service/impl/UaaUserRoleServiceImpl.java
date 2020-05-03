package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUserRole;
import com.learn.auth.dto.UaaUserRoleDto;
import com.learn.auth.converter.UaaUserRoleConverter;
import com.learn.auth.repository.UaaUserRoleRepository;
import com.learn.auth.service.UaaUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserRoleServiceImpl extends ServiceImpl<UaaUserRoleRepository, UaaUserRole> implements UaaUserRoleService {

     @Override
     public UaaUserRoleDto save(UaaUserRoleDto uaaUserRoleDto) {
         UaaUserRole uaaUserRole = UaaUserRoleConverter.INSTANCE.convert(uaaUserRoleDto);

         save(uaaUserRole);

         return UaaUserRoleConverter.INSTANCE.convertDto(uaaUserRole);
     }

     @Override
     public UaaUserRoleDto update(UaaUserRoleDto uaaUserRoleDto) {
         UaaUserRole uaaUserRole = UaaUserRoleConverter.INSTANCE.convert(uaaUserRoleDto);

         updateById(uaaUserRole);

         return UaaUserRoleConverter.INSTANCE.convertDto(uaaUserRole);
     }

 }
