package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaMenuElement;
import io.github.suxil.auth.dto.UaaMenuElementDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 菜单页面元素信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaMenuElementConverter {

    UaaMenuElementConverter INSTANCE = Mappers.getMapper(UaaMenuElementConverter.class);

    UaaMenuElement convert(UaaMenuElementDto item);

    UaaMenuElementDto convertDto(UaaMenuElement item);

    List<UaaMenuElement> convert(List<UaaMenuElementDto> list);

    List<UaaMenuElementDto> convertDto(List<UaaMenuElement> list);

}
