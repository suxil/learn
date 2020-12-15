package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaMenuElement;
import io.github.suxil.auth.dto.UaaMenuElementDto;
import io.github.suxil.auth.converter.UaaMenuElementConverter;
import io.github.suxil.auth.repository.UaaMenuElementRepository;
import io.github.suxil.auth.service.UaaMenuElementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单页面元素信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaMenuElementServiceImpl extends ServiceImpl<UaaMenuElementRepository, UaaMenuElement> implements UaaMenuElementService {

     @Override
     public UaaMenuElementDto save(UaaMenuElementDto uaaMenuElementDto) {
         UaaMenuElement uaaMenuElement = UaaMenuElementConverter.INSTANCE.convert(uaaMenuElementDto);

         save(uaaMenuElement);

         return UaaMenuElementConverter.INSTANCE.convertDto(uaaMenuElement);
     }

     @Override
     public UaaMenuElementDto update(UaaMenuElementDto uaaMenuElementDto) {
         UaaMenuElement uaaMenuElement = UaaMenuElementConverter.INSTANCE.convert(uaaMenuElementDto);

         updateById(uaaMenuElement);

         return UaaMenuElementConverter.INSTANCE.convertDto(uaaMenuElement);
     }

 }
