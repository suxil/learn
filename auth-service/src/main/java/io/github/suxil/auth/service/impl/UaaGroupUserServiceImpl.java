package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaGroupUser;
import io.github.suxil.auth.dto.UaaGroupUserDto;
import io.github.suxil.auth.converter.UaaGroupUserConverter;
import io.github.suxil.auth.repository.UaaGroupUserRepository;
import io.github.suxil.auth.service.UaaGroupUserService;
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
