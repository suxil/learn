package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaPermissionConverter;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionTreeDto;
import com.learn.auth.repository.UaaPermissionRepository;
import com.learn.auth.service.UaaPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaPermissionServiceImpl extends ServiceImpl<UaaPermissionRepository, UaaPermission> implements UaaPermissionService {

    @Override
    public List<UaaPermissionTreeDto> selectPermissionTree(String officeCode) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaPermission.OFFICE_CODE, officeCode);
        return UaaPermissionConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
