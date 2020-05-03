package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUserPosition;
import com.learn.auth.dto.UaaUserPositionDto;
import com.learn.auth.converter.UaaUserPositionConverter;
import com.learn.auth.repository.UaaUserPositionRepository;
import com.learn.auth.service.UaaUserPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-岗位信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserPositionServiceImpl extends ServiceImpl<UaaUserPositionRepository, UaaUserPosition> implements UaaUserPositionService {

     @Override
     public UaaUserPositionDto save(UaaUserPositionDto uaaUserPositionDto) {
         UaaUserPosition uaaUserPosition = UaaUserPositionConverter.INSTANCE.convert(uaaUserPositionDto);

         save(uaaUserPosition);

         return UaaUserPositionConverter.INSTANCE.convertDto(uaaUserPosition);
     }

     @Override
     public UaaUserPositionDto update(UaaUserPositionDto uaaUserPositionDto) {
         UaaUserPosition uaaUserPosition = UaaUserPositionConverter.INSTANCE.convert(uaaUserPositionDto);

         updateById(uaaUserPosition);

         return UaaUserPositionConverter.INSTANCE.convertDto(uaaUserPosition);
     }

 }
