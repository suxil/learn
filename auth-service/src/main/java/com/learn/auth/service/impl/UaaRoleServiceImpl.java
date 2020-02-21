package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaRoleConverter;
import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleTreeDto;
import com.learn.auth.repository.UaaRoleRepository;
import com.learn.auth.service.UaaRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaRoleServiceImpl extends ServiceImpl<UaaRoleRepository, UaaRole> implements UaaRoleService {

    @Override
    public List<UaaRoleTreeDto> selectRoleTree(String officeCode) {
        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaRole.OFFICE_CODE, officeCode);
        return UaaRoleConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
