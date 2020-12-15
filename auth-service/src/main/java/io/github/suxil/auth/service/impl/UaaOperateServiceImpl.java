package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaOperate;
import io.github.suxil.auth.dto.UaaOperateDto;
import io.github.suxil.auth.converter.UaaOperateConverter;
import io.github.suxil.auth.repository.UaaOperateRepository;
import io.github.suxil.auth.service.UaaOperateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaOperateServiceImpl extends ServiceImpl<UaaOperateRepository, UaaOperate> implements UaaOperateService {

     @Override
     public UaaOperateDto save(UaaOperateDto uaaOperateDto) {
         UaaOperate uaaOperate = UaaOperateConverter.INSTANCE.convert(uaaOperateDto);

         save(uaaOperate);

         return UaaOperateConverter.INSTANCE.convertDto(uaaOperate);
     }

     @Override
     public UaaOperateDto update(UaaOperateDto uaaOperateDto) {
         UaaOperate uaaOperate = UaaOperateConverter.INSTANCE.convert(uaaOperateDto);

         updateById(uaaOperate);

         return UaaOperateConverter.INSTANCE.convertDto(uaaOperate);
     }

 }
