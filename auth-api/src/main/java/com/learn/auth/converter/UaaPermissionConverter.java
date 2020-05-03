package com.learn.auth.converter;

import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionDto;
import com.learn.auth.vo.UaaPermissionTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPermissionConverter {

    UaaPermissionConverter INSTANCE = Mappers.getMapper(UaaPermissionConverter.class);

    UaaPermission convert(UaaPermissionDto item);

    UaaPermissionDto convertDto(UaaPermission item);

    List<UaaPermission> convert(List<UaaPermissionDto> list);

    List<UaaPermissionDto> convertDto(List<UaaPermission> list);

    UaaPermissionTreeVo convertTreeVo(UaaPermission item);

    List<UaaPermissionTreeVo> convertTreeVo(List<UaaPermission> list);

    default List<UaaPermissionTreeVo> convertToTree(List<UaaPermission> uaaPermissionList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaPermissionList), UaaPermissionTreeVo::getId, UaaPermissionTreeVo::getParentId, UaaPermissionTreeVo::setChildren);
    }

}
