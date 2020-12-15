package io.github.suxil.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.auth.domain.UaaPermission;
import io.github.suxil.auth.dto.UaaPermissionDto;
import io.github.suxil.auth.converter.UaaPermissionConverter;
import io.github.suxil.auth.repository.UaaPermissionRepository;
import io.github.suxil.auth.service.UaaPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.suxil.auth.vo.UaaPermissionTreeVo;
import io.github.suxil.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaPermissionServiceImpl extends ServiceImpl<UaaPermissionRepository, UaaPermission> implements UaaPermissionService {

     @Override
     public UaaPermissionDto save(UaaPermissionDto uaaPermissionDto) {
         UaaPermission uaaPermission = UaaPermissionConverter.INSTANCE.convert(uaaPermissionDto);

         save(uaaPermission);

         return UaaPermissionConverter.INSTANCE.convertDto(uaaPermission);
     }

     @Override
     public UaaPermissionDto update(UaaPermissionDto uaaPermissionDto) {
         UaaPermission uaaPermission = UaaPermissionConverter.INSTANCE.convert(uaaPermissionDto);

         updateById(uaaPermission);

         return UaaPermissionConverter.INSTANCE.convertDto(uaaPermission);
     }

    @Override
    public List<UaaPermissionTreeVo> selectPermissionTree(String officeCode) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaPermissionConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
