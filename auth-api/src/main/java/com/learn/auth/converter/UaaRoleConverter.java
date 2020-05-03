package com.learn.auth.converter;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.vo.UaaRoleTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaRoleConverter {

    UaaRoleConverter INSTANCE = Mappers.getMapper(UaaRoleConverter.class);

    UaaRoleTreeVo convert(UaaRole item);

    List<UaaRoleTreeVo> convert(List<UaaRole> list);

    default List<UaaRoleTreeVo> convertToTree(List<UaaRole> uaaRoleList) {
        return TreeUtils.convertToTree(convert(uaaRoleList), UaaRoleTreeVo::getId, UaaRoleTreeVo::getParentId, UaaRoleTreeVo::setChildren);
    }

}
