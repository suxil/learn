package ${package.Controller};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${table.entityName};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import ${package.Service}.${table.entityName}Service;
import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.common.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Api(value = "${table.comment!} 接口")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.entityName}Service ${table.entityName?uncap_first}Service;

    @GetMapping
    @ApiOperation(value = "${table.comment!} 分页查询")
    public ResponseResult<PageResult<${table.entityName}Dto>> list(${table.entityName}Dto ${table.entityName?uncap_first}Dto) {
        PageResult<${table.entityName}Dto> pageResult = ${table.entityName?uncap_first}Service.page(${table.entityName?uncap_first}Dto);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "${table.comment!} 详情")
    public ResponseResult<${table.entityName}Dto> load(@PathVariable String id) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.get${table.entityName}ById(id));
    }

    @PostMapping
    @ApiOperation(value = "${table.comment!} 创建")
    public ResponseResult<${table.entityName}Dto> create(@RequestBody ${table.entityName}Dto ${table.entityName?uncap_first}Dto) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.save(${table.entityName?uncap_first}Dto));
    }

    @PutMapping
    @ApiOperation(value = "${table.comment!} 更新")
    public ResponseResult<${table.entityName}Dto> update(@RequestBody ${table.entityName}Dto ${table.entityName?uncap_first}Dto) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.update(${table.entityName?uncap_first}Dto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "${table.comment!} 删除")
    public ResponseResult<Boolean> delete(@PathVariable String id) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.removeById(id));
    }

}
</#if>
