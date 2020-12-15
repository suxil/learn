package io.github.suxil.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.auth.domain.UaaPosition;
import io.github.suxil.auth.dto.UaaPositionDto;
import io.github.suxil.auth.converter.UaaPositionConverter;
import io.github.suxil.auth.repository.UaaPositionRepository;
import io.github.suxil.auth.service.UaaPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.suxil.auth.vo.UaaPositionTreeVo;
import io.github.suxil.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaPositionServiceImpl extends ServiceImpl<UaaPositionRepository, UaaPosition> implements UaaPositionService {

     @Override
     public UaaPositionDto save(UaaPositionDto uaaPositionDto) {
         UaaPosition uaaPosition = UaaPositionConverter.INSTANCE.convert(uaaPositionDto);

         save(uaaPosition);

         return UaaPositionConverter.INSTANCE.convertDto(uaaPosition);
     }

     @Override
     public UaaPositionDto update(UaaPositionDto uaaPositionDto) {
         UaaPosition uaaPosition = UaaPositionConverter.INSTANCE.convert(uaaPositionDto);

         updateById(uaaPosition);

         return UaaPositionConverter.INSTANCE.convertDto(uaaPosition);
     }

    @Override
    public List<UaaPositionTreeVo> selectPositionTree(String officeCode) {
        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaPositionConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
