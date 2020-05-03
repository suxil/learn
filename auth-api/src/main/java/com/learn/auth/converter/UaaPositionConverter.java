package com.learn.auth.converter;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.dto.UaaPositionDto;
import com.learn.auth.vo.UaaPositionTreeVo;
import com.learn.core.util.TreeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UaaPositionConverter {

    UaaPositionConverter INSTANCE = Mappers.getMapper(UaaPositionConverter.class);

    UaaPosition convert(UaaPositionDto item);

    UaaPositionDto convertDto(UaaPosition item);

    List<UaaPosition> convert(List<UaaPositionDto> list);

    List<UaaPositionDto> convertDto(List<UaaPosition> list);

    UaaPositionTreeVo convertTreeVo(UaaPosition item);

    List<UaaPositionTreeVo> convertTreeVo(List<UaaPosition> list);

    default List<UaaPositionTreeVo> convertToTree(List<UaaPosition> uaaPositionList) {
        return TreeUtils.convertToTree(convertTreeVo(uaaPositionList), UaaPositionTreeVo::getId, UaaPositionTreeVo::getParentId, UaaPositionTreeVo::setChildren);
    }

}
