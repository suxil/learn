package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.builder.UaaGroupBuilder;
import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.domain.UaaGroup;
import com.learn.auth.dto.UaaGroupTreeDto;
import com.learn.auth.repository.UaaGroupRepository;
import com.learn.auth.service.UaaGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaGroupServiceImpl extends ServiceImpl<UaaGroupRepository, UaaGroup> implements UaaGroupService {

    @Override
    public List<UaaGroupTreeDto> selectGroupTree(String officeCode) {
        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaDepartment.OFFICE_CODE, officeCode);
        return UaaGroupBuilder.convertToTree(super.list(queryWrapper));
    }

}
