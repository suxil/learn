package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUserPermission;
import com.learn.auth.dto.UaaUserPermissionDto;
import com.learn.auth.converter.UaaUserPermissionConverter;
import com.learn.auth.repository.UaaUserPermissionRepository;
import com.learn.auth.service.UaaUserPermissionService;
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
