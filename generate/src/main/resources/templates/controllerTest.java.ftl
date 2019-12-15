package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.${table.entityName};
import com.learn.auth.service.${table.entityName}Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器 测试用例
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName}Test extends ${superControllerClass} {
<#else>
public class ${table.controllerName}Test {
</#if>

    @Autowired
    private ${table.entityName}Service ${table.entityName?uncap_first}Service;

    @Test
    public void list() {
        Page<${table.entityName}> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();

        IPage<${table.entityName}> pageResult = ${table.entityName?uncap_first}Service.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        ${table.entityName} ${table.entityName?uncap_first} = ${table.entityName?uncap_first}Service.getById(id);

        Assert.assertNotNull(${table.entityName?uncap_first});
    }

    @Test
    @Rollback
    public void create() {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();
        ${table.entityName?uncap_first}Service.saveOrUpdate(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void update() {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();
        ${table.entityName?uncap_first}Service.saveOrUpdate(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        ${table.entityName?uncap_first}Service.removeById(id);

    }

}
</#if>
