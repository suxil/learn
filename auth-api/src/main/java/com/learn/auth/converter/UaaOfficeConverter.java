package com.learn.auth.converter;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeDto;
import com.learn.auth.vo.UaaOfficeTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaOfficeConverter {

    UaaOfficeConverter INSTANCE = Mappers.getMapper(UaaOfficeConverter.class);

    UaaOffice convert(UaaOfficeDto item);

    UaaOfficeDto convertDto(UaaOffice item);

    List<UaaOffice> convert(List<UaaOfficeDto> list);

    List<UaaOfficeDto> convertDto(List<UaaOffice> list);

    UaaOfficeTreeVo convertTreeVo(UaaOffice item);

    List<UaaOfficeTreeVo> convertTreeVo(List<UaaOffice> list);

    default List<UaaOfficeTreeVo> convertToTree(List<UaaOffice> uaaOfficeList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaOfficeList), UaaOfficeTreeVo::getId, UaaOfficeTreeVo::getParentId, UaaOfficeTreeVo::setChildren);
    }

}
