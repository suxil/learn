package ${package.Service};

import ${package.Entity}.${entity};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 保存 ${table.comment!}
     */
    ${entity}Dto save(${entity}Dto ${entity?uncap_first}Dto);

    /**
     * 更新 ${table.comment!}
     */
    ${entity}Dto update(${entity}Dto ${entity?uncap_first}Dto);

}
</#if>
