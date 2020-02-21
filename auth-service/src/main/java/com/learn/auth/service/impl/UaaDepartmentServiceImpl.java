package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaDepartmentConverter;
import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentTreeDto;
import com.learn.auth.repository.UaaDepartmentRepository;
import com.learn.auth.service.UaaDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaDepartmentServiceImpl extends ServiceImpl<UaaDepartmentRepository, UaaDepartment> implements UaaDepartmentService {

    @Override
    public List<UaaDepartmentTreeDto> selectDepartmentTree(String officeCode) {
        QueryWrapper<UaaDepartment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaDepartment.OFFICE_CODE, officeCode);
        return UaaDepartmentConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
