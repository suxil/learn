package com.learn.auth.builder;
import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.dto.UaaGroupTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:30
 *
 * @author suxi
 * @version V1.0
 */
public class UaaGroupBuilder {

    public static List<UaaGroupTreeDto> convertToTree(List<UaaGroup> uaaGroupList) {
        return TreeUtils.convertToTree(convert(uaaGroupList), UaaGroupTreeDto::getId, UaaGroupTreeDto::getParentId, UaaGroupTreeDto::setChildren);
    }

    public static List<UaaGroupTreeDto> convert(List<UaaGroup> uaaGroupList) {
        List<UaaGroupTreeDto> uaaGroupTreeDtoList = Lists.newArrayList();
        for (UaaGroup uaaGroup : uaaGroupList) {
            uaaGroupTreeDtoList.add(convert(uaaGroup));
        }
        return uaaGroupTreeDtoList;
    }

    public static UaaGroupTreeDto convert(UaaGroup uaaGroup) {
        UaaGroupTreeDto uaaGroupTreeDto = new UaaGroupTreeDto();
        uaaGroupTreeDto.setId(uaaGroup.getId());
        uaaGroupTreeDto.setParentId(uaaGroup.getParentId());
        uaaGroupTreeDto.setSeq(uaaGroup.getSeq());
        uaaGroupTreeDto.setLevel(uaaGroup.getLevel());
        uaaGroupTreeDto.setGroupCode(uaaGroup.getGroupCode());
        uaaGroupTreeDto.setGroupName(uaaGroup.getGroupName());
        return uaaGroupTreeDto;
    }

}
