package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaMenu;
import io.github.suxil.auth.dto.UaaMenuDto;
import io.github.suxil.auth.vo.UaaMenuTreeVo;
import io.github.suxil.core.util.TreeUtils;
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
