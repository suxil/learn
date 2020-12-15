package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaDepartmentPosition;
import io.github.suxil.auth.dto.UaaDepartmentPositionDto;
import io.github.suxil.auth.converter.UaaDepartmentPositionConverter;
import io.github.suxil.auth.repository.UaaDepartmentPositionRepository;
import io.github.suxil.auth.service.UaaDepartmentPositionService;
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
