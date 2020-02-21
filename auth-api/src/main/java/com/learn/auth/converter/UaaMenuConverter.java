package com.learn.auth.converter;

import com.learn.auth.domain.UaaMenu;
import com.learn.auth.dto.UaaMenuTreeDto;
import com.learn.core.utils.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaMenuConverter {

    UaaMenuConverter INSTANCE = Mappers.getMapper(UaaMenuConverter.class);

    UaaMenuTreeDto convert(UaaMenu item);

    List<UaaMenuTreeDto> convert(List<UaaMenu> list);

    default List<UaaMenuTreeDto> convertToTree(List<UaaMenu> uaaMenuList) {
        return TreeUtils.convertToTree(convert(uaaMenuList), UaaMenuTreeDto::getId, UaaMenuTreeDto::getParentId, UaaMenuTreeDto::setChildren);
    }

}
