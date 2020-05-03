package com.learn.auth.converter;

import com.learn.auth.domain.UaaPermission;
import com.learn.auth.vo.UaaPermissionTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPermissionConverter {

    UaaPermissionConverter INSTANCE = Mappers.getMapper(UaaPermissionConverter.class);

    UaaPermissionTreeVo convert(UaaPermission item);

    List<UaaPermissionTreeVo> convert(List<UaaPermission> list);

    default List<UaaPermissionTreeVo> convertToTree(List<UaaPermission> uaaPermissionList) {
        return TreeUtils.convertToTree(convert(uaaPermissionList), UaaPermissionTreeVo::getId, UaaPermissionTreeVo::getParentId, UaaPermissionTreeVo::setChildren);
    }

}
