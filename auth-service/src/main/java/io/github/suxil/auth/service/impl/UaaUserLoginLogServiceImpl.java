package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaUserLoginLog;
import io.github.suxil.auth.dto.UaaUserLoginLogDto;
import io.github.suxil.auth.converter.UaaUserLoginLogConverter;
import io.github.suxil.auth.repository.UaaUserLoginLogRepository;
import io.github.suxil.auth.service.UaaUserLoginLogService;
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
