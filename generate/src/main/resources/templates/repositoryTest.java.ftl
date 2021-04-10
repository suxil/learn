package ${package.Mapper};

import ${package.Entity}.${entity};
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ${table.comment!} 服务类 测试用例
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
interface ${table.mapperName} : ${superServiceClass}<${entity}>
<#else>
public class ${table.mapperName}Test {

    @Autowired
    private ${table.entityName}Repository ${table.entityName?uncap_first}Repository;

}
</#if>
