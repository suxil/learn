package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaPermission;
import io.github.suxil.auth.dto.UaaPermissionDto;
import io.github.suxil.auth.vo.UaaPermissionTreeVo;
import io.github.suxil.core.util.TreeUtils;
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
