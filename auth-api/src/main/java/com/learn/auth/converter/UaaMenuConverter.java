package com.learn.auth.converter;

import com.learn.auth.domain.UaaMenu;
import com.learn.auth.dto.UaaMenuDto;
import com.learn.auth.vo.UaaMenuTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaMenuConverter {

    UaaMenuConverter INSTANCE = Mappers.getMapper(UaaMenuConverter.class);

    UaaMenu convert(UaaMenuDto item);

    UaaMenuDto convertDto(UaaMenu item);

    List<UaaMenu> convert(List<UaaMenuDto> list);

    List<UaaMenuDto> convertDto(List<UaaMenu> list);

    UaaMenuTreeVo convertTreeVo(UaaMenu item);

    List<UaaMenuTreeVo> convertTreeVo(List<UaaMenu> list);

    default List<UaaMenuTreeVo> convertToTree(List<UaaMenu> uaaMenuList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaMenuList), UaaMenuTreeVo::getId, UaaMenuTreeVo::getParentId, UaaMenuTreeVo::setChildren);
    }

}
