package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaGroupRole;
import io.github.suxil.auth.dto.UaaGroupRoleDto;
import io.github.suxil.auth.converter.UaaGroupRoleConverter;
import io.github.suxil.auth.repository.UaaGroupRoleRepository;
import io.github.suxil.auth.service.UaaGroupRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaGroupRoleServiceImpl extends ServiceImpl<UaaGroupRoleRepository, UaaGroupRole> implements UaaGroupRoleService {

     @Override
     public UaaGroupRoleDto save(UaaGroupRoleDto uaaGroupRoleDto) {
         UaaGroupRole uaaGroupRole = UaaGroupRoleConverter.INSTANCE.convert(uaaGroupRoleDto);

         save(uaaGroupRole);

         return UaaGroupRoleConverter.INSTANCE.convertDto(uaaGroupRole);
     }

     @Override
     public UaaGroupRoleDto update(UaaGroupRoleDto uaaGroupRoleDto) {
         UaaGroupRole uaaGroupRole = UaaGroupRoleConverter.INSTANCE.convert(uaaGroupRoleDto);

         updateById(uaaGroupRole);

         return UaaGroupRoleConverter.INSTANCE.convertDto(uaaGroupRole);
     }

 }
