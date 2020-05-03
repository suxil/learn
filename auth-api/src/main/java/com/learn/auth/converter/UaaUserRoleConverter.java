package com.learn.auth.converter;

import com.learn.auth.domain.UaaUserRole;
import com.learn.auth.dto.UaaUserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaUserRoleConverter {

    UaaUserRoleConverter INSTANCE = Mappers.getMapper(UaaUserRoleConverter.class);

    UaaUserRole convert(UaaUserRoleDto item);

    UaaUserRoleDto convertDto(UaaUserRole item);

    List<UaaUserRole> convert(List<UaaUserRoleDto> list);

    List<UaaUserRoleDto> convertDto(List<UaaUserRole> list);

}
