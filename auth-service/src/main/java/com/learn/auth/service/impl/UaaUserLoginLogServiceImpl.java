package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaUserLoginLog;
import com.learn.auth.dto.UaaUserLoginLogDto;
import com.learn.auth.converter.UaaUserLoginLogConverter;
import com.learn.auth.repository.UaaUserLoginLogRepository;
import com.learn.auth.service.UaaUserLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录日志 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserLoginLogServiceImpl extends ServiceImpl<UaaUserLoginLogRepository, UaaUserLoginLog> implements UaaUserLoginLogService {

     @Override
     public UaaUserLoginLogDto save(UaaUserLoginLogDto uaaUserLoginLogDto) {
         UaaUserLoginLog uaaUserLoginLog = UaaUserLoginLogConverter.INSTANCE.convert(uaaUserLoginLogDto);

         save(uaaUserLoginLog);

         return UaaUserLoginLogConverter.INSTANCE.convertDto(uaaUserLoginLog);
     }

     @Override
     public UaaUserLoginLogDto update(UaaUserLoginLogDto uaaUserLoginLogDto) {
         UaaUserLoginLog uaaUserLoginLog = UaaUserLoginLogConverter.INSTANCE.convert(uaaUserLoginLogDto);

         updateById(uaaUserLoginLog);

         return UaaUserLoginLogConverter.INSTANCE.convertDto(uaaUserLoginLog);
     }

 }
