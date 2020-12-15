package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaMenuElementRole;
import io.github.suxil.auth.dto.UaaMenuElementRoleDto;
import io.github.suxil.auth.converter.UaaMenuElementRoleConverter;
import io.github.suxil.auth.repository.UaaMenuElementRoleRepository;
import io.github.suxil.auth.service.UaaMenuElementRoleService;
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
