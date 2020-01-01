package com.learn.auth.builder;
import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.dto.UaaDepartmentTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:26
 *
 * @author suxi
 * @version V1.0
 */
public class UaaDepartmentBuilder {

    public static List<UaaDepartmentTreeDto> convertToTree(List<UaaDepartment> uaaDepartmentList) {
        return TreeUtils.convertToTree(convert(uaaDepartmentList), UaaDepartmentTreeDto::getId, UaaDepartmentTreeDto::getParentId, UaaDepartmentTreeDto::setChildren);
    }

    public static List<UaaDepartmentTreeDto> convert(List<UaaDepartment> uaaDepartmentList) {
        List<UaaDepartmentTreeDto> uaaDepartmentTreeDtoList = Lists.newArrayList();
        for (UaaDepartment uaaDepartment : uaaDepartmentList) {
            uaaDepartmentTreeDtoList.add(convert(uaaDepartment));
        }
        return uaaDepartmentTreeDtoList;
    }

    public static UaaDepartmentTreeDto convert(UaaDepartment uaaDepartment) {
        UaaDepartmentTreeDto uaaDepartmentTreeDto = new UaaDepartmentTreeDto();
        uaaDepartmentTreeDto.setId(uaaDepartment.getId());
        uaaDepartmentTreeDto.setParentId(uaaDepartment.getParentId());
        uaaDepartmentTreeDto.setSeq(uaaDepartment.getSeq());
        uaaDepartmentTreeDto.setLevel(uaaDepartment.getLevel());
        uaaDepartmentTreeDto.setDepartmentCode(uaaDepartment.getDepartmentCode());
        uaaDepartmentTreeDto.setDepartmentName(uaaDepartment.getDepartmentName());
        return uaaDepartmentTreeDto;
    }

}
