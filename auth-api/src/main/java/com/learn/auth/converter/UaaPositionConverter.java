package com.learn.auth.converter;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionTreeDto;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPositionConverter {

    UaaPositionConverter INSTANCE = Mappers.getMapper(UaaPositionConverter.class);

    UaaPositionTreeDto convert(UaaPosition item);

    List<UaaPositionTreeDto> convert(List<UaaPosition> list);

    default List<UaaPositionTreeDto> convertToTree(List<UaaPosition> uaaPositionList) {
        return TreeUtils.convertToTree(convert(uaaPositionList), UaaPositionTreeDto::getId, UaaPositionTreeDto::getParentId, UaaPositionTreeDto::setChildren);
    }

}
