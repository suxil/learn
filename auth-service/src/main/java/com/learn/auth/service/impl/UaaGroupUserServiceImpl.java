package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.dto.UaaGroupUserDto;
import com.learn.auth.converter.UaaGroupUserConverter;
import com.learn.auth.repository.UaaGroupUserRepository;
import com.learn.auth.service.UaaGroupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组-用户信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaGroupUserServiceImpl extends ServiceImpl<UaaGroupUserRepository, UaaGroupUser> implements UaaGroupUserService {

     @Override
     public UaaGroupUserDto save(UaaGroupUserDto uaaGroupUserDto) {
         UaaGroupUser uaaGroupUser = UaaGroupUserConverter.INSTANCE.convert(uaaGroupUserDto);

         save(uaaGroupUser);

         return UaaGroupUserConverter.INSTANCE.convertDto(uaaGroupUser);
     }

     @Override
     public UaaGroupUserDto update(UaaGroupUserDto uaaGroupUserDto) {
         UaaGroupUser uaaGroupUser = UaaGroupUserConverter.INSTANCE.convert(uaaGroupUserDto);

         updateById(uaaGroupUser);

         return UaaGroupUserConverter.INSTANCE.convertDto(uaaGroupUser);
     }

 }
