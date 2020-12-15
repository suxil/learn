package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaDepartment;
import io.github.suxil.auth.dto.UaaDepartmentDto;
import io.github.suxil.auth.vo.UaaDepartmentTreeVo;
import io.github.suxil.core.util.TreeUtils;
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
