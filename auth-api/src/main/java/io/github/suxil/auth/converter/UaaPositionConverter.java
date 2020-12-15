package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaPosition;
import io.github.suxil.auth.dto.UaaPositionDto;
import io.github.suxil.auth.vo.UaaPositionTreeVo;
import io.github.suxil.core.util.TreeUtils;
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
