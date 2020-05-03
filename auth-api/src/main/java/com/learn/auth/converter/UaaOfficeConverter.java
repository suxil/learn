package com.learn.auth.converter;

import com.learn.auth.domain.UaaOffice;
import com.learn.auth.vo.UaaOfficeTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaOfficeConverter {

    UaaOfficeConverter INSTANCE = Mappers.getMapper(UaaOfficeConverter.class);

    UaaOfficeTreeVo convert(UaaOffice item);

    List<UaaOfficeTreeVo> convert(List<UaaOffice> list);

    default List<UaaOfficeTreeVo> convertToTree(List<UaaOffice> uaaOfficeList) {
        return TreeUtils.convertToTree(convert(uaaOfficeList), UaaOfficeTreeVo::getId, UaaOfficeTreeVo::getParentId, UaaOfficeTreeVo::setChildren);
    }

}
