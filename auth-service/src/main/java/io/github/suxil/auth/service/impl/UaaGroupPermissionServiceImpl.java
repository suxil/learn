package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaGroupPermission;
import io.github.suxil.auth.dto.UaaGroupPermissionDto;
import io.github.suxil.auth.converter.UaaGroupPermissionConverter;
import io.github.suxil.auth.repository.UaaGroupPermissionRepository;
import io.github.suxil.auth.service.UaaGroupPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaGroupPermissionServiceImpl extends ServiceImpl<UaaGroupPermissionRepository, UaaGroupPermission> implements UaaGroupPermissionService {

     @Override
     public UaaGroupPermissionDto save(UaaGroupPermissionDto uaaGroupPermissionDto) {
         UaaGroupPermission uaaGroupPermission = UaaGroupPermissionConverter.INSTANCE.convert(uaaGroupPermissionDto);

         save(uaaGroupPermission);

         return UaaGroupPermissionConverter.INSTANCE.convertDto(uaaGroupPermission);
     }

     @Override
     public UaaGroupPermissionDto update(UaaGroupPermissionDto uaaGroupPermissionDto) {
         UaaGroupPermission uaaGroupPermission = UaaGroupPermissionConverter.INSTANCE.convert(uaaGroupPermissionDto);

         updateById(uaaGroupPermission);

         return UaaGroupPermissionConverter.INSTANCE.convertDto(uaaGroupPermission);
     }

 }
