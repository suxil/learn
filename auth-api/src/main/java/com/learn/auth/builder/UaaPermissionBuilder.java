package com.learn.auth.builder;

import com.google.common.collect.Lists;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.dto.UaaPermissionTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:45
 *
 * @author suxi
 * @version V1.0
 */
public class UaaPermissionBuilder {

    public static List<UaaPermissionTreeDto> convertToTree(List<UaaPermission> uaaPermissionList) {
        return TreeUtils.convertToTree(convert(uaaPermissionList), UaaPermissionTreeDto::getId, UaaPermissionTreeDto::getParentId, UaaPermissionTreeDto::setChildren);
    }

    public static List<UaaPermissionTreeDto> convert(List<UaaPermission> uaaPositionList) {
        List<UaaPermissionTreeDto> uaaPermissionTreeDtoList = Lists.newArrayList();
        for (UaaPermission uaaPermission : uaaPositionList) {
            uaaPermissionTreeDtoList.add(convert(uaaPermission));
        }
        return uaaPermissionTreeDtoList;
    }

    public static UaaPermissionTreeDto convert(UaaPermission uaaPermission) {
        UaaPermissionTreeDto uaaPermissionTreeDto = new UaaPermissionTreeDto();
        uaaPermissionTreeDto.setId(uaaPermission.getId());
        uaaPermissionTreeDto.setParentId(uaaPermission.getParentId());
        uaaPermissionTreeDto.setSeq(uaaPermission.getSeq());
        uaaPermissionTreeDto.setPermissionCode(uaaPermission.getPermissionCode());
        uaaPermissionTreeDto.setPermissionName(uaaPermission.getPermissionName());
        return uaaPermissionTreeDto;
    }


}
