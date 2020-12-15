package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaUserPermission;
import io.github.suxil.auth.dto.UaaUserPermissionDto;
import io.github.suxil.auth.converter.UaaUserPermissionConverter;
import io.github.suxil.auth.repository.UaaUserPermissionRepository;
import io.github.suxil.auth.service.UaaUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserPermissionServiceImpl extends ServiceImpl<UaaUserPermissionRepository, UaaUserPermission> implements UaaUserPermissionService {

     @Override
     public UaaUserPermissionDto save(UaaUserPermissionDto uaaUserPermissionDto) {
         UaaUserPermission uaaUserPermission = UaaUserPermissionConverter.INSTANCE.convert(uaaUserPermissionDto);

         save(uaaUserPermission);

         return UaaUserPermissionConverter.INSTANCE.convertDto(uaaUserPermission);
     }

     @Override
     public UaaUserPermissionDto update(UaaUserPermissionDto uaaUserPermissionDto) {
         UaaUserPermission uaaUserPermission = UaaUserPermissionConverter.INSTANCE.convert(uaaUserPermissionDto);

         updateById(uaaUserPermission);

         return UaaUserPermissionConverter.INSTANCE.convertDto(uaaUserPermission);
     }

 }
