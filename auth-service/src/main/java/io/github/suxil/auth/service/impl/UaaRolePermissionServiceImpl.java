package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaRolePermission;
import io.github.suxil.auth.dto.UaaRolePermissionDto;
import io.github.suxil.auth.converter.UaaRolePermissionConverter;
import io.github.suxil.auth.repository.UaaRolePermissionRepository;
import io.github.suxil.auth.service.UaaRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaRolePermissionServiceImpl extends ServiceImpl<UaaRolePermissionRepository, UaaRolePermission> implements UaaRolePermissionService {

     @Override
     public UaaRolePermissionDto save(UaaRolePermissionDto uaaRolePermissionDto) {
         UaaRolePermission uaaRolePermission = UaaRolePermissionConverter.INSTANCE.convert(uaaRolePermissionDto);

         save(uaaRolePermission);

         return UaaRolePermissionConverter.INSTANCE.convertDto(uaaRolePermission);
     }

     @Override
     public UaaRolePermissionDto update(UaaRolePermissionDto uaaRolePermissionDto) {
         UaaRolePermission uaaRolePermission = UaaRolePermissionConverter.INSTANCE.convert(uaaRolePermissionDto);

         updateById(uaaRolePermission);

         return UaaRolePermissionConverter.INSTANCE.convertDto(uaaRolePermission);
     }

 }
