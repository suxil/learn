package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaUser;
import io.github.suxil.auth.dto.UaaUserDto;
import io.github.suxil.auth.converter.UaaUserConverter;
import io.github.suxil.auth.repository.UaaUserRepository;
import io.github.suxil.auth.service.UaaUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaUserServiceImpl extends ServiceImpl<UaaUserRepository, UaaUser> implements UaaUserService {

     @Override
     public UaaUserDto save(UaaUserDto uaaUserDto) {
         UaaUser uaaUser = UaaUserConverter.INSTANCE.convert(uaaUserDto);

         save(uaaUser);

         return UaaUserConverter.INSTANCE.convertDto(uaaUser);
     }

     @Override
     public UaaUserDto update(UaaUserDto uaaUserDto) {
         UaaUser uaaUser = UaaUserConverter.INSTANCE.convert(uaaUserDto);

         updateById(uaaUser);

         return UaaUserConverter.INSTANCE.convertDto(uaaUser);
     }

 }
