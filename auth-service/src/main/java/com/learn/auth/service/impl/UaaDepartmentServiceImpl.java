package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentDto;
import com.learn.auth.converter.UaaDepartmentConverter;
import com.learn.auth.repository.UaaDepartmentRepository;
import com.learn.auth.service.UaaDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.vo.UaaDepartmentTreeVo;
import com.learn.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaDepartmentServiceImpl extends ServiceImpl<UaaDepartmentRepository, UaaDepartment> implements UaaDepartmentService {

     @Override
     public UaaDepartmentDto save(UaaDepartmentDto uaaDepartmentDto) {
         UaaDepartment uaaDepartment = UaaDepartmentConverter.INSTANCE.convert(uaaDepartmentDto);

         save(uaaDepartment);

         return UaaDepartmentConverter.INSTANCE.convertDto(uaaDepartment);
     }

     @Override
     public UaaDepartmentDto update(UaaDepartmentDto uaaDepartmentDto) {
         UaaDepartment uaaDepartment = UaaDepartmentConverter.INSTANCE.convert(uaaDepartmentDto);

         updateById(uaaDepartment);

         return UaaDepartmentConverter.INSTANCE.convertDto(uaaDepartment);
     }

    @Override
    public List<UaaDepartmentTreeVo> selectDepartmentTree(String officeCode) {
        QueryWrapper<UaaDepartment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaDepartmentConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
