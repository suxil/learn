package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaOperate;
import com.learn.auth.dto.UaaOperateDto;
import com.learn.auth.converter.UaaOperateConverter;
import com.learn.auth.repository.UaaOperateRepository;
import com.learn.auth.service.UaaOperateService;
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
