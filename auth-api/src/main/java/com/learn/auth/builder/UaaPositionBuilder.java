package com.learn.auth.builder;
import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:41
 *
 * @author suxi
 * @version V1.0
 */
public class UaaPositionBuilder {

    public static List<UaaPositionTreeDto> convertToTree(List<UaaPosition> uaaPositionList) {
        return TreeUtils.convertToTree(convert(uaaPositionList), UaaPositionTreeDto::getId, UaaPositionTreeDto::getParentId, UaaPositionTreeDto::setChildren);
    }

    public static List<UaaPositionTreeDto> convert(List<UaaPosition> uaaPositionList) {
        List<UaaPositionTreeDto> uaaPositionTreeDtoList = Lists.newArrayList();
        for (UaaPosition uaaPosition : uaaPositionList) {
            uaaPositionTreeDtoList.add(convert(uaaPosition));
        }
        return uaaPositionTreeDtoList;
    }

    public static UaaPositionTreeDto convert(UaaPosition uaaPosition) {
        UaaPositionTreeDto uaaPositionTreeDto = new UaaPositionTreeDto();
        uaaPositionTreeDto.setId(uaaPosition.getId());
        uaaPositionTreeDto.setParentId(uaaPosition.getParentId());
        uaaPositionTreeDto.setSeq(uaaPosition.getSeq());
        uaaPositionTreeDto.setLevel(uaaPosition.getLevel());
        uaaPositionTreeDto.setPositionCode(uaaPosition.getPositionCode());
        uaaPositionTreeDto.setPositionName(uaaPosition.getPositionName());
        return uaaPositionTreeDto;
    }

}
