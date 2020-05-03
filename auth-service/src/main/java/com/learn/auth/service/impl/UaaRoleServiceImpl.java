package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleDto;
import com.learn.auth.converter.UaaRoleConverter;
import com.learn.auth.repository.UaaRoleRepository;
import com.learn.auth.service.UaaRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.vo.UaaRoleTreeVo;
import com.learn.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class UaaRoleServiceImpl extends ServiceImpl<UaaRoleRepository, UaaRole> implements UaaRoleService {

     @Override
     public UaaRoleDto save(UaaRoleDto uaaRoleDto) {
         UaaRole uaaRole = UaaRoleConverter.INSTANCE.convert(uaaRoleDto);

         save(uaaRole);

         return UaaRoleConverter.INSTANCE.convertDto(uaaRole);
     }

     @Override
     public UaaRoleDto update(UaaRoleDto uaaRoleDto) {
         UaaRole uaaRole = UaaRoleConverter.INSTANCE.convert(uaaRoleDto);

         updateById(uaaRole);

         return UaaRoleConverter.INSTANCE.convertDto(uaaRole);
     }

    @Override
    public List<UaaRoleTreeVo> selectRoleTree(String officeCode) {
        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaRoleConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
