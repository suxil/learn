package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaGroupConverter;
import com.learn.auth.domain.UaaGroup;
import com.learn.auth.repository.UaaGroupRepository;
import com.learn.auth.service.UaaGroupService;
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
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaGroupServiceImpl extends ServiceImpl<UaaGroupRepository, UaaGroup> implements UaaGroupService {

    @Override
    public List<UaaGroupTreeVo> selectGroupTree(String officeCode) {
        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaGroupConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
