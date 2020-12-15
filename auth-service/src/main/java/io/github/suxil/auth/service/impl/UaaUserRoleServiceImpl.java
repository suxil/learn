package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaUserRole;
import io.github.suxil.auth.dto.UaaUserRoleDto;
import io.github.suxil.auth.converter.UaaUserRoleConverter;
import io.github.suxil.auth.repository.UaaUserRoleRepository;
import io.github.suxil.auth.service.UaaUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserRoleServiceImpl extends ServiceImpl<UaaUserRoleRepository, UaaUserRole> implements UaaUserRoleService {

     @Override
     public UaaUserRoleDto save(UaaUserRoleDto uaaUserRoleDto) {
         UaaUserRole uaaUserRole = UaaUserRoleConverter.INSTANCE.convert(uaaUserRoleDto);

         save(uaaUserRole);

         return UaaUserRoleConverter.INSTANCE.convertDto(uaaUserRole);
     }

     @Override
     public UaaUserRoleDto update(UaaUserRoleDto uaaUserRoleDto) {
         UaaUserRole uaaUserRole = UaaUserRoleConverter.INSTANCE.convert(uaaUserRoleDto);

         updateById(uaaUserRole);

         return UaaUserRoleConverter.INSTANCE.convertDto(uaaUserRole);
     }

 }
