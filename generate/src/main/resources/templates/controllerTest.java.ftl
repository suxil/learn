package ${package.Controller};

import ${package.Entity}.${entity};
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * ${table.comment!} 前端控制器 测试用例
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@WithMockUser
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
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
    private MockMvc mockMvc;

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(get("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void loadTest() throws Exception {
        String id = "";

        mockMvc.perform(get("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void createTest() throws Exception {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();

        mockMvc.perform(post("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>").content(${table.entityName?uncap_first}.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        ${table.entityName} ${table.entityName?uncap_first} = new ${table.entityName}();

        mockMvc.perform(put("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>").content(${table.entityName?uncap_first}.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void deleteTest() throws Exception {
        String id = "";

        mockMvc.perform(delete("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}
</#if>
