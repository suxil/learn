package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaMenuConverter;
import com.learn.auth.domain.UaaMenu;
import com.learn.auth.dto.UaaMenuTreeDto;
import com.learn.auth.repository.UaaMenuRepository;
import com.learn.auth.service.UaaMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
public class UaaMenuServiceImpl extends ServiceImpl<UaaMenuRepository, UaaMenu> implements UaaMenuService {

    @Override
    public List<UaaMenuTreeDto> selectMenuTree(String officeCode) {
        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UaaMenu.OFFICE_CODE, officeCode);
        return UaaMenuConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

}
