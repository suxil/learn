package ${package.Service};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import ${package.Entity?replace("domain","converter")}.${entity}Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ${table.comment!} 服务类 测试用例
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ActiveProfiles({"dev"})
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public class ${table.serviceName}Test {

    @Autowired
    private ${table.entityName}Service ${table.entityName?uncap_first}Service;

    @Test
    @Rollback
    public void listTest() {
        Page<${table.entityName}> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();

        IPage<${table.entityName}> pageResult = ${table.entityName?uncap_first}Service.page(page, queryWrapper);

        Assertions.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        ${table.entityName} ${table.entityName?uncap_first} = ${table.entityName?uncap_first}Service.getById(id);

        Assertions.assertNotNull(${table.entityName?uncap_first});
    }

    @Test
    @Rollback
    public void createTest() {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();
        ${table.entityName?uncap_first}Service.saveOrUpdate(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void updateTest() {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();
        ${table.entityName?uncap_first}Service.saveOrUpdate(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        ${table.entityName?uncap_first}Service.removeById(id);

    }

}
</#if>
