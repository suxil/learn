package io.github.suxil.auth.web.api.v1;

import io.github.suxil.auth.domain.UaaUserPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 用户-权限信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-02-21
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles({"dev"})
public class UaaUserPermissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(get("/api/v1/uaa-user-permissions"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void loadTest() throws Exception {
        String id = "";

        mockMvc.perform(get("/api/v1/uaa-user-permissions/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void createTest() throws Exception {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();

        mockMvc.perform(post("/api/v1/uaa-user-permissions").content(uaaUserPermission.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();

        mockMvc.perform(put("/api/v1/uaa-user-permissions").content(uaaUserPermission.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void deleteTest() throws Exception {
        String id = "";

        mockMvc.perform(delete("/api/v1/uaa-user-permissions/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}
