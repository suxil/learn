package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaMenuElementRole;
import com.learn.auth.dto.UaaMenuElementRoleDto;
import com.learn.auth.converter.UaaMenuElementRoleConverter;
import com.learn.auth.repository.UaaMenuElementRoleRepository;
import com.learn.auth.service.UaaMenuElementRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单菜单页面元素-角色息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaMenuElementRoleServiceImpl extends ServiceImpl<UaaMenuElementRoleRepository, UaaMenuElementRole> implements UaaMenuElementRoleService {

     @Override
     public UaaMenuElementRoleDto save(UaaMenuElementRoleDto uaaMenuElementRoleDto) {
         UaaMenuElementRole uaaMenuElementRole = UaaMenuElementRoleConverter.INSTANCE.convert(uaaMenuElementRoleDto);

         save(uaaMenuElementRole);

         return UaaMenuElementRoleConverter.INSTANCE.convertDto(uaaMenuElementRole);
     }

     @Override
     public UaaMenuElementRoleDto update(UaaMenuElementRoleDto uaaMenuElementRoleDto) {
         UaaMenuElementRole uaaMenuElementRole = UaaMenuElementRoleConverter.INSTANCE.convert(uaaMenuElementRoleDto);

         updateById(uaaMenuElementRole);

         return UaaMenuElementRoleConverter.INSTANCE.convertDto(uaaMenuElementRole);
     }

 }
