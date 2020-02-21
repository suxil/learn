package com.learn.auth.converter;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.dto.UaaGroupTreeDto;
import com.learn.core.utils.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaGroupConverter {

    UaaGroupConverter INSTANCE = Mappers.getMapper(UaaGroupConverter.class);

    UaaGroupTreeDto convert(UaaGroup item);

    List<UaaGroupTreeDto> convert(List<UaaGroup> list);

    default List<UaaGroupTreeDto> convertToTree(List<UaaGroup> uaaGroupList) {
        return TreeUtils.convertToTree(convert(uaaGroupList), UaaGroupTreeDto::getId, UaaGroupTreeDto::getParentId, UaaGroupTreeDto::setChildren);
    }

}
