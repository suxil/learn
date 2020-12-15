package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaRole;
import io.github.suxil.auth.dto.UaaRoleDto;
import io.github.suxil.auth.vo.UaaRoleTreeVo;
import io.github.suxil.core.util.TreeUtils;
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
