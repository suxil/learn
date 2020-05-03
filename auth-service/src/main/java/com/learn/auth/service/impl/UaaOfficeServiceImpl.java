package com.learn.auth.service.impl;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeDto;
import com.learn.auth.converter.UaaOfficeConverter;
import com.learn.auth.repository.UaaOfficeRepository;
import com.learn.auth.service.UaaOfficeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.vo.UaaOfficeTreeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaOfficeServiceImpl extends ServiceImpl<UaaOfficeRepository, UaaOffice> implements UaaOfficeService {

     @Override
     public UaaOfficeDto save(UaaOfficeDto uaaOfficeDto) {
         UaaOffice uaaOffice = UaaOfficeConverter.INSTANCE.convert(uaaOfficeDto);

         save(uaaOffice);

         return UaaOfficeConverter.INSTANCE.convertDto(uaaOffice);
     }

     @Override
     public UaaOfficeDto update(UaaOfficeDto uaaOfficeDto) {
         UaaOffice uaaOffice = UaaOfficeConverter.INSTANCE.convert(uaaOfficeDto);

         updateById(uaaOffice);

         return UaaOfficeConverter.INSTANCE.convertDto(uaaOffice);
     }

    @Override
    public List<UaaOfficeTreeVo> selectOfficeTree() {
        return UaaOfficeConverter.INSTANCE.convertToTree(super.list());
    }

 }
