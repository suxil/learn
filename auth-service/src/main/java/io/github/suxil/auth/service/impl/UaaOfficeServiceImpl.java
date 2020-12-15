package io.github.suxil.auth.service.impl;

import io.github.suxil.auth.domain.UaaOffice;
import io.github.suxil.auth.dto.UaaOfficeDto;
import io.github.suxil.auth.converter.UaaOfficeConverter;
import io.github.suxil.auth.repository.UaaOfficeRepository;
import io.github.suxil.auth.service.UaaOfficeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.suxil.auth.vo.UaaOfficeTreeVo;
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
