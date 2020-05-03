package com.learn.auth.converter;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.vo.UaaPositionTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPositionConverter {

    UaaPositionConverter INSTANCE = Mappers.getMapper(UaaPositionConverter.class);

    UaaPositionTreeVo convert(UaaPosition item);

    List<UaaPositionTreeVo> convert(List<UaaPosition> list);

    default List<UaaPositionTreeVo> convertToTree(List<UaaPosition> uaaPositionList) {
        return TreeUtils.convertToTree(convert(uaaPositionList), UaaPositionTreeVo::getId, UaaPositionTreeVo::getParentId, UaaPositionTreeVo::setChildren);
    }

}
