package com.learn.auth.converter;

import com.learn.auth.domain.UaaMenuRole;
import com.learn.auth.dto.UaaMenuRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 菜单-角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaMenuRoleConverter {

    UaaMenuRoleConverter INSTANCE = Mappers.getMapper(UaaMenuRoleConverter.class);

    UaaMenuRole convert(UaaMenuRoleDto item);

    UaaMenuRoleDto convertDto(UaaMenuRole item);

    List<UaaMenuRole> convert(List<UaaMenuRoleDto> list);

    List<UaaMenuRoleDto> convertDto(List<UaaMenuRole> list);

}
