package com.learn.auth.converter;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentTreeDto;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaDepartmentConverter {

    UaaDepartmentConverter INSTANCE = Mappers.getMapper(UaaDepartmentConverter.class);

    UaaDepartmentTreeDto convert(UaaDepartment item);

    List<UaaDepartmentTreeDto> convert(List<UaaDepartment> list);

    default List<UaaDepartmentTreeDto> convertToTree(List<UaaDepartment> uaaDepartmentList) {
        return TreeUtils.convertToTree(convert(uaaDepartmentList), UaaDepartmentTreeDto::getId, UaaDepartmentTreeDto::getParentId, UaaDepartmentTreeDto::setChildren);
    }

}
