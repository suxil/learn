package com.learn.auth.converter;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.dto.UaaGroupDto;
import com.learn.auth.vo.UaaGroupTreeVo;
import com.learn.core.util.TreeUtils;
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
