package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaUserPosition;
import io.github.suxil.auth.dto.UaaUserPositionDto;
import io.github.suxil.auth.converter.UaaUserPositionConverter;
import io.github.suxil.auth.repository.UaaUserPositionRepository;
import io.github.suxil.auth.service.UaaUserPositionService;
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
