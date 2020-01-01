package com.learn.auth.builder;
import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaMenu;
import com.learn.auth.dto.UaaMenuTreeDto;
import com.learn.core.utils.TreeUtils;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:35
 *
 * @author suxi
 * @version V1.0
 */
public class UaaMenuBuilder {

    public static List<UaaMenuTreeDto> convertToTree(List<UaaMenu> uaaMenuList) {
        return TreeUtils.convertToTree(convert(uaaMenuList), UaaMenuTreeDto::getId, UaaMenuTreeDto::getParentId, UaaMenuTreeDto::setChildren);
    }

    public static List<UaaMenuTreeDto> convert(List<UaaMenu> uaaMenuList) {
        List<UaaMenuTreeDto> uaaMenuTreeDtoList = Lists.newArrayList();
        for (UaaMenu uaaMenu : uaaMenuList) {
            uaaMenuTreeDtoList.add(convert(uaaMenu));
        }
        return uaaMenuTreeDtoList;
    }

    public static UaaMenuTreeDto convert(UaaMenu uaaMenu) {
        UaaMenuTreeDto uaaMenuTreeDto = new UaaMenuTreeDto();
        uaaMenuTreeDto.setId(uaaMenu.getId());
        uaaMenuTreeDto.setParentId(uaaMenu.getParentId());
        uaaMenuTreeDto.setSeq(uaaMenu.getSeq());
        uaaMenuTreeDto.setLevel(uaaMenu.getLevel());
        uaaMenuTreeDto.setMenuCode(uaaMenu.getMenuCode());
        uaaMenuTreeDto.setMenuName(uaaMenu.getMenuName());
        return uaaMenuTreeDto;
    }

}
