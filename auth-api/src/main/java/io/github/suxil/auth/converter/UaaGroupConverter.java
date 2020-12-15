package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaGroup;
import io.github.suxil.auth.dto.UaaGroupDto;
import io.github.suxil.auth.vo.UaaGroupTreeVo;
import io.github.suxil.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaGroupConverter {

    UaaGroupConverter INSTANCE = Mappers.getMapper(UaaGroupConverter.class);

    UaaGroup convert(UaaGroupDto item);

    UaaGroupDto convertDto(UaaGroup item);

    List<UaaGroup> convert(List<UaaGroupDto> list);

    List<UaaGroupDto> convertDto(List<UaaGroup> list);

    UaaGroupTreeVo convertVo(UaaGroup item);

    List<UaaGroupTreeVo> convertVo(List<UaaGroup> list);

    default List<UaaGroupTreeVo> convertToTree(List<UaaGroup> uaaGroupList) {
        return TreeUtils.convertToTree(convertVo(uaaGroupList), UaaGroupTreeVo::getId, UaaGroupTreeVo::getParentId, UaaGroupTreeVo::setChildren);
    }

}
