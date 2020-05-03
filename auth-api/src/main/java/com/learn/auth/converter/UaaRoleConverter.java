package com.learn.auth.converter;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleDto;
import com.learn.auth.vo.UaaRoleTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaRoleConverter {

    UaaRoleConverter INSTANCE = Mappers.getMapper(UaaRoleConverter.class);

    UaaRole convert(UaaRoleDto item);

    UaaRoleDto convertDto(UaaRole item);

    List<UaaRole> convert(List<UaaRoleDto> list);

    List<UaaRoleDto> convertDto(List<UaaRole> list);

    UaaRoleTreeVo convertTreeVo(UaaRole item);

    List<UaaRoleTreeVo> convertTreeVo(List<UaaRole> list);

    default List<UaaRoleTreeVo> convertToTree(List<UaaRole> uaaRoleList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaRoleList), UaaRoleTreeVo::getId, UaaRoleTreeVo::getParentId, UaaRoleTreeVo::setChildren);
    }

}
