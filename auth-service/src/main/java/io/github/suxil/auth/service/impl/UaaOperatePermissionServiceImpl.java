package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaOperatePermission;
import io.github.suxil.auth.dto.UaaOperatePermissionDto;
import io.github.suxil.auth.converter.UaaOperatePermissionConverter;
import io.github.suxil.auth.repository.UaaOperatePermissionRepository;
import io.github.suxil.auth.service.UaaOperatePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作-权限息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaOperatePermissionServiceImpl extends ServiceImpl<UaaOperatePermissionRepository, UaaOperatePermission> implements UaaOperatePermissionService {

     @Override
     public UaaOperatePermissionDto save(UaaOperatePermissionDto uaaOperatePermissionDto) {
         UaaOperatePermission uaaOperatePermission = UaaOperatePermissionConverter.INSTANCE.convert(uaaOperatePermissionDto);

         save(uaaOperatePermission);

         return UaaOperatePermissionConverter.INSTANCE.convertDto(uaaOperatePermission);
     }

     @Override
     public UaaOperatePermissionDto update(UaaOperatePermissionDto uaaOperatePermissionDto) {
         UaaOperatePermission uaaOperatePermission = UaaOperatePermissionConverter.INSTANCE.convert(uaaOperatePermissionDto);

         updateById(uaaOperatePermission);

         return UaaOperatePermissionConverter.INSTANCE.convertDto(uaaOperatePermission);
     }

 }
