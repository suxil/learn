package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaPositionConverter;
import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionTreeDto;
import com.learn.auth.repository.UaaPositionRepository;
import com.learn.auth.service.UaaPositionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaPositionServiceImpl extends ServiceImpl<UaaPositionRepository, UaaPosition> implements UaaPositionService {

    @Override
    public List<UaaPositionTreeDto> selectPositionTree(String officeCode) {
        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaPosition.OFFICE_CODE, officeCode);
        return UaaPositionConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
