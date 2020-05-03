package ${package.Entity};

import ${package.Entity}.${entity};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Mapper
public interface ${entity}Converter {

    ${entity}Converter INSTANCE = Mappers.getMapper(${entity}Converter.class);

    ${entity} convert(${entity}Dto item);

    ${entity}Dto convertDto(${entity} item);

    List<${entity}> convert(List<${entity}Dto> list);

    List<${entity}Dto> convertDto(List<${entity}> list);

}
