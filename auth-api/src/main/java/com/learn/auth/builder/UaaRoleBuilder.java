package com.learn.auth.builder;
import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:17
 *
 * @author suxi
 * @version V1.0
 */
public class UaaRoleBuilder {

    public static List<UaaRoleTreeDto> convertToTree(List<UaaRole> uaaRoleList) {
        return TreeUtils.convertToTree(convert(uaaRoleList), UaaRoleTreeDto::getId, UaaRoleTreeDto::getParentId, UaaRoleTreeDto::setChildren);
    }

    public static List<UaaRoleTreeDto> convert(List<UaaRole> uaaRoleList) {
        List<UaaRoleTreeDto> uaaRoleTreeDtoList = Lists.newArrayList();
        for (UaaRole uaaRole : uaaRoleList) {
            uaaRoleTreeDtoList.add(convert(uaaRole));
        }
        return uaaRoleTreeDtoList;
    }

    public static UaaRoleTreeDto convert(UaaRole uaaRole) {
        UaaRoleTreeDto uaaRoleTreeDto = new UaaRoleTreeDto();
        uaaRoleTreeDto.setId(uaaRole.getId());
        uaaRoleTreeDto.setParentId(uaaRole.getParentId());
        uaaRoleTreeDto.setSeq(uaaRole.getSeq());
        uaaRoleTreeDto.setLevel(uaaRole.getLevel());
        uaaRoleTreeDto.setRoleCode(uaaRole.getRoleCode());
        uaaRoleTreeDto.setRoleName(uaaRole.getRoleName());
        return uaaRoleTreeDto;
    }

}
