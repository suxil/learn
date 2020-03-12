package com.learn.auth.converter;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleTreeDto;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaRoleConverter {

    UaaRoleConverter INSTANCE = Mappers.getMapper(UaaRoleConverter.class);

    UaaRoleTreeDto convert(UaaRole item);

    List<UaaRoleTreeDto> convert(List<UaaRole> list);

    default List<UaaRoleTreeDto> convertToTree(List<UaaRole> uaaRoleList) {
        return TreeUtils.convertToTree(convert(uaaRoleList), UaaRoleTreeDto::getId, UaaRoleTreeDto::getParentId, UaaRoleTreeDto::setChildren);
    }

}
