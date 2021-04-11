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
        ${table.entityName}Dto ${table.entityName?uncap_first}Dto = new ${table.entityName}Dto();
        ${table.entityName?uncap_first}Dto.setPage(0L);
        ${table.entityName?uncap_first}Dto.setSize(10L);

        PageResult<${table.entityName}Dto> pageResult = ${table.entityName?uncap_first}Service.page(cdmDictDto);

        Assertions.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        ${table.entityName}Dto ${table.entityName?uncap_first}Dto = ${table.entityName?uncap_first}Service.get${table.entityName}ById(id);

        Assertions.assertNotNull(${table.entityName?uncap_first}Dto);
    }

    @Test
    @Rollback
    public void createTest() {
        ${table.entityName}Dto ${table.entityName?uncap_first}Dto = new ${table.entityName}Dto();
        ${table.entityName?uncap_first}Service.save(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void updateTest() {
        ${table.entityName}Dto ${table.entityName?uncap_first}Dto = new ${table.entityName}Dto();
        ${table.entityName?uncap_first}Service.update(${table.entityName?uncap_first});

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        ${table.entityName?uncap_first}Service.removeById(id);

    }

}
</#if>
