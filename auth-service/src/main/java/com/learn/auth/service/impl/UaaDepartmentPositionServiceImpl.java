package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.dto.UaaDepartmentPositionDto;
import com.learn.auth.converter.UaaDepartmentPositionConverter;
import com.learn.auth.repository.UaaDepartmentPositionRepository;
import com.learn.auth.service.UaaDepartmentPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门-岗位信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaDepartmentPositionServiceImpl extends ServiceImpl<UaaDepartmentPositionRepository, UaaDepartmentPosition> implements UaaDepartmentPositionService {

     @Override
     public UaaDepartmentPositionDto save(UaaDepartmentPositionDto uaaDepartmentPositionDto) {
         UaaDepartmentPosition uaaDepartmentPosition = UaaDepartmentPositionConverter.INSTANCE.convert(uaaDepartmentPositionDto);

         save(uaaDepartmentPosition);

         return UaaDepartmentPositionConverter.INSTANCE.convertDto(uaaDepartmentPosition);
     }

     @Override
     public UaaDepartmentPositionDto update(UaaDepartmentPositionDto uaaDepartmentPositionDto) {
         UaaDepartmentPosition uaaDepartmentPosition = UaaDepartmentPositionConverter.INSTANCE.convert(uaaDepartmentPositionDto);

         updateById(uaaDepartmentPosition);

         return UaaDepartmentPositionConverter.INSTANCE.convertDto(uaaDepartmentPosition);
     }

 }
