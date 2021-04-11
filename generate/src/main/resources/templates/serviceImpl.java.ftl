package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import ${package.Entity?replace("domain","converter")}.${entity}Converter;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.core.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Slf4j
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public PageResult<${table.entityName}Dto> page(${entity}Dto ${entity?uncap_first}Dto) {
        QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();

        PageInfo<${table.entityName}> pageInfo = PageHelper.startPage(${entity?uncap_first}Dto.getPage().intValue(), ${entity?uncap_first}Dto.getSize().intValue())
            .doSelectPageInfo(() -> list(queryWrapper));

        PageResult<${table.entityName}Dto> pageResult = PageUtils.pageInfoToPageResult(pageInfo);
        pageResult.setList(${entity}Converter.INSTANCE.convertDto(pageInfo.getList()));

        return pageResult;
    }

    @Override
    public ${entity}Dto get${table.entityName}ById(String id) {
        ${entity} ${entity?uncap_first} = getById(id);

        return ${entity}Converter.INSTANCE.convertDto(${entity?uncap_first});
    }

    @Override
    public ${entity}Dto save(${entity}Dto ${entity?uncap_first}Dto) {
        ${entity} ${entity?uncap_first} = ${entity}Converter.INSTANCE.convert(${entity?uncap_first}Dto);

        save(${entity?uncap_first});

        return ${entity}Converter.INSTANCE.convertDto(${entity?uncap_first});
    }

    @Override
    public ${entity}Dto update(${entity}Dto ${entity?uncap_first}Dto) {
        ${entity} ${entity?uncap_first} = ${entity}Converter.INSTANCE.convert(${entity?uncap_first}Dto);

        updateById(${entity?uncap_first});

        return ${entity}Converter.INSTANCE.convertDto(${entity?uncap_first});
    }

}
</#if>
