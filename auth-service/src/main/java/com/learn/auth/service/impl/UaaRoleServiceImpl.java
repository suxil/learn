package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaRoleConverter;
import com.learn.auth.domain.UaaRole;
import com.learn.auth.repository.UaaRoleRepository;
import com.learn.auth.service.UaaRoleService;
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
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaRoleServiceImpl extends ServiceImpl<UaaRoleRepository, UaaRole> implements UaaRoleService {

    @Override
    public List<UaaRoleTreeVo> selectRoleTree(String officeCode) {
        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaRoleConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
