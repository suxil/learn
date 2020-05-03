package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaMenuElement;
import com.learn.auth.dto.UaaMenuElementDto;
import com.learn.auth.converter.UaaMenuElementConverter;
import com.learn.auth.repository.UaaMenuElementRepository;
import com.learn.auth.service.UaaMenuElementService;
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
