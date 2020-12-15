package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaMenuRole;
import io.github.suxil.auth.dto.UaaMenuRoleDto;
import io.github.suxil.auth.converter.UaaMenuRoleConverter;
import io.github.suxil.auth.repository.UaaMenuRoleRepository;
import io.github.suxil.auth.service.UaaMenuRoleService;
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
