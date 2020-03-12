package com.learn.auth.converter;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeTreeDto;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaOfficeConverter {

    UaaOfficeConverter INSTANCE = Mappers.getMapper(UaaOfficeConverter.class);

    UaaOfficeTreeDto convert(UaaOffice item);

    List<UaaOfficeTreeDto> convert(List<UaaOffice> list);

    default List<UaaOfficeTreeDto> convertToTree(List<UaaOffice> uaaOfficeList) {
        return TreeUtils.convertToTree(convert(uaaOfficeList), UaaOfficeTreeDto::getId, UaaOfficeTreeDto::getParentId, UaaOfficeTreeDto::setChildren);
    }

}
