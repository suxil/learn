package com.learn.auth.converter;

import com.learn.auth.domain.UaaMenu;
import com.learn.auth.vo.UaaMenuTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaMenuConverter {

    UaaMenuConverter INSTANCE = Mappers.getMapper(UaaMenuConverter.class);

    UaaMenuTreeVo convert(UaaMenu item);

    List<UaaMenuTreeVo> convert(List<UaaMenu> list);

    default List<UaaMenuTreeVo> convertToTree(List<UaaMenu> uaaMenuList) {
        return TreeUtils.convertToTree(convert(uaaMenuList), UaaMenuTreeVo::getId, UaaMenuTreeVo::getParentId, UaaMenuTreeVo::setChildren);
    }

}
