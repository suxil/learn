package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaGroupRole;
import io.github.suxil.auth.dto.UaaGroupRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 组-角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaGroupRoleConverter {

    UaaGroupRoleConverter INSTANCE = Mappers.getMapper(UaaGroupRoleConverter.class);

    UaaGroupRole convert(UaaGroupRoleDto item);

    UaaGroupRoleDto convertDto(UaaGroupRole item);

    List<UaaGroupRole> convert(List<UaaGroupRoleDto> list);

    List<UaaGroupRoleDto> convertDto(List<UaaGroupRole> list);

}
