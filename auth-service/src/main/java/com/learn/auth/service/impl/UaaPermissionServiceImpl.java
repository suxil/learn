package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.builder.UaaPermissionBuilder;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionTreeDto;
import com.learn.auth.repository.UaaPermissionRepository;
import com.learn.auth.service.UaaPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UaaPermissionServiceImpl extends ServiceImpl<UaaPermissionRepository, UaaPermission> implements UaaPermissionService {

    @Override
    public List<UaaPermissionTreeDto> selectPermissionTree(String officeCode) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaPermission.OFFICE_CODE, officeCode);
        return UaaPermissionBuilder.convertToTree(super.list(queryWrapper));
    }

}
