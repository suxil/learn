package io.github.suxil.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.auth.domain.UaaMenu;
import io.github.suxil.auth.dto.UaaMenuDto;
import io.github.suxil.auth.converter.UaaMenuConverter;
import io.github.suxil.auth.repository.UaaMenuRepository;
import io.github.suxil.auth.service.UaaMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.suxil.auth.vo.UaaMenuTreeVo;
import io.github.suxil.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Service
@Slf4j
public class UaaMenuServiceImpl extends ServiceImpl<UaaMenuRepository, UaaMenu> implements UaaMenuService {

     @Override
     public UaaMenuDto save(UaaMenuDto uaaMenuDto) {
         UaaMenu uaaMenu = UaaMenuConverter.INSTANCE.convert(uaaMenuDto);

         save(uaaMenu);

         return UaaMenuConverter.INSTANCE.convertDto(uaaMenu);
     }

     @Override
     public UaaMenuDto update(UaaMenuDto uaaMenuDto) {
         UaaMenu uaaMenu = UaaMenuConverter.INSTANCE.convert(uaaMenuDto);

         updateById(uaaMenu);

         return UaaMenuConverter.INSTANCE.convertDto(uaaMenu);
     }

    @Override
    public List<UaaMenuTreeVo> selectMenuTree(String officeCode) {
        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseDomainConstants.OFFICE_CODE, officeCode);
        return UaaMenuConverter.INSTANCE.convertToTree(super.list(queryWrapper));
    }

 }
