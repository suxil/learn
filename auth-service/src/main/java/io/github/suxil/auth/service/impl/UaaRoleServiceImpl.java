package io.github.suxil.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.auth.domain.UaaRole;
import io.github.suxil.auth.dto.UaaRoleDto;
import io.github.suxil.auth.converter.UaaRoleConverter;
import io.github.suxil.auth.repository.UaaRoleRepository;
import io.github.suxil.auth.service.UaaRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.suxil.auth.vo.UaaRoleTreeVo;
import io.github.suxil.core.constance.BaseDomainConstants;
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
