package com.learn.auth.converter;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.vo.UaaDepartmentTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaDepartmentConverter {

    UaaDepartmentConverter INSTANCE = Mappers.getMapper(UaaDepartmentConverter.class);

    UaaDepartmentTreeVo convert(UaaDepartment item);

    List<UaaDepartmentTreeVo> convert(List<UaaDepartment> list);

    default List<UaaDepartmentTreeVo> convertToTree(List<UaaDepartment> uaaDepartmentList) {
        return TreeUtils.convertToTree(convert(uaaDepartmentList), UaaDepartmentTreeVo::getId, UaaDepartmentTreeVo::getParentId, UaaDepartmentTreeVo::setChildren);
    }

}
