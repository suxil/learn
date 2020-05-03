package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaMenuRole;
import com.learn.auth.dto.UaaMenuRoleDto;
import com.learn.auth.converter.UaaMenuRoleConverter;
import com.learn.auth.repository.UaaMenuRoleRepository;
import com.learn.auth.service.UaaMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单-角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaMenuRoleServiceImpl extends ServiceImpl<UaaMenuRoleRepository, UaaMenuRole> implements UaaMenuRoleService {

     @Override
     public UaaMenuRoleDto save(UaaMenuRoleDto uaaMenuRoleDto) {
         UaaMenuRole uaaMenuRole = UaaMenuRoleConverter.INSTANCE.convert(uaaMenuRoleDto);

         save(uaaMenuRole);

         return UaaMenuRoleConverter.INSTANCE.convertDto(uaaMenuRole);
     }

     @Override
     public UaaMenuRoleDto update(UaaMenuRoleDto uaaMenuRoleDto) {
         UaaMenuRole uaaMenuRole = UaaMenuRoleConverter.INSTANCE.convert(uaaMenuRoleDto);

         updateById(uaaMenuRole);

         return UaaMenuRoleConverter.INSTANCE.convertDto(uaaMenuRole);
     }

 }
