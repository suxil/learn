package com.learn.auth.converter;

import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionTreeDto;
import com.learn.core.utils.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPermissionConverter {

    UaaPermissionConverter INSTANCE = Mappers.getMapper(UaaPermissionConverter.class);

    UaaPermissionTreeDto convert(UaaPermission item);

    List<UaaPermissionTreeDto> convert(List<UaaPermission> list);

    default List<UaaPermissionTreeDto> convertToTree(List<UaaPermission> uaaPermissionList) {
        return TreeUtils.convertToTree(convert(uaaPermissionList), UaaPermissionTreeDto::getId, UaaPermissionTreeDto::getParentId, UaaPermissionTreeDto::setChildren);
    }

}
