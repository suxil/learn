package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaOperatePermission;
import com.learn.auth.dto.UaaOperatePermissionDto;
import com.learn.auth.converter.UaaOperatePermissionConverter;
import com.learn.auth.repository.UaaOperatePermissionRepository;
import com.learn.auth.service.UaaOperatePermissionService;
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
