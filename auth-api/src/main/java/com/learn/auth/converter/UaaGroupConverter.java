package com.learn.auth.converter;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.vo.UaaGroupTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaGroupConverter {

    UaaGroupConverter INSTANCE = Mappers.getMapper(UaaGroupConverter.class);

    UaaGroupTreeVo convert(UaaGroup item);

    List<UaaGroupTreeVo> convert(List<UaaGroup> list);

    default List<UaaGroupTreeVo> convertToTree(List<UaaGroup> uaaGroupList) {
        return TreeUtils.convertToTree(convert(uaaGroupList), UaaGroupTreeVo::getId, UaaGroupTreeVo::getParentId, UaaGroupTreeVo::setChildren);
    }

}
