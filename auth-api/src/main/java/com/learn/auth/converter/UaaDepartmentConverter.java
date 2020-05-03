package com.learn.auth.converter;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentDto;
import com.learn.auth.vo.UaaDepartmentTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaDepartmentConverter {

    UaaDepartmentConverter INSTANCE = Mappers.getMapper(UaaDepartmentConverter.class);

    UaaDepartment convert(UaaDepartmentDto item);

    UaaDepartmentDto convertDto(UaaDepartment item);

    List<UaaDepartment> convert(List<UaaDepartmentDto> list);

    List<UaaDepartmentDto> convertDto(List<UaaDepartment> list);

    UaaDepartmentTreeVo convertTreeVo(UaaDepartment item);

    List<UaaDepartmentTreeVo> convertTreeVo(List<UaaDepartment> list);

    default List<UaaDepartmentTreeVo> convertToTree(List<UaaDepartment> uaaDepartmentList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaDepartmentList), UaaDepartmentTreeVo::getId, UaaDepartmentTreeVo::getParentId, UaaDepartmentTreeVo::setChildren);
    }

}
