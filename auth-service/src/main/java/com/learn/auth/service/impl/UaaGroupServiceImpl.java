package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.domain.UaaGroup;
import com.learn.auth.dto.UaaGroupDto;
import com.learn.auth.converter.UaaGroupConverter;
import com.learn.auth.repository.UaaGroupRepository;
import com.learn.auth.service.UaaGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.vo.UaaGroupTreeVo;
import com.learn.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaGroupServiceImpl extends ServiceImpl<UaaGroupRepository, UaaGroup> implements UaaGroupService {

     @Override
     public UaaGroupDto save(UaaGroupDto uaaGroupDto) {
         UaaGroup uaaGroup = UaaGroupConverter.INSTANCE.convert(uaaGroupDto);

         save(uaaGroup);

         return UaaGroupConverter.INSTANCE.convertDto(uaaGroup);
     }

     @Override
     public UaaGroupDto update(UaaGroupDto uaaGroupDto) {
         UaaGroup uaaGroup = UaaGroupConverter.INSTANCE.convert(uaaGroupDto);

         updateById(uaaGroup);

         return UaaGroupConverter.INSTANCE.convertDto(uaaGroup);
     }

    @Override
    public List<UaaGroupTreeVo> selectGroupTree(String officeCode) {
        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaGroupConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
