package com.learn.auth.builder;

import com.google.common.collect.Lists;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeTreeDto;

import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 11:28
 *
 * @author suxi
 * @version V1.0
 */
public class UaaOfficeBuilder {

    public static List<UaaOfficeTreeDto> convert(List<UaaOffice> uaaOfficeList) {
        List<UaaOfficeTreeDto> uaaOfficeTreeDtoList = Lists.newArrayList();
        for (UaaOffice uaaOffice : uaaOfficeList) {
            uaaOfficeTreeDtoList.add(convert(uaaOffice));
        }
        return uaaOfficeTreeDtoList;
    }

    public static UaaOfficeTreeDto convert(UaaOffice uaaOffice) {
        UaaOfficeTreeDto uaaOfficeTreeDto = new UaaOfficeTreeDto();
        uaaOfficeTreeDto.setId(uaaOffice.getId());
        uaaOfficeTreeDto.setParentId(uaaOffice.getParentId());
        uaaOfficeTreeDto.setSeq(uaaOffice.getSeq());
        uaaOfficeTreeDto.setLevel(uaaOffice.getLevel());
        uaaOfficeTreeDto.setOfficeCode(uaaOffice.getOfficeCode());
        uaaOfficeTreeDto.setOfficeName(uaaOffice.getOfficeName());
        return uaaOfficeTreeDto;
    }

}
