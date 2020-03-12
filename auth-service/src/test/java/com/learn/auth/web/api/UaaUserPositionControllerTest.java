package com.learn.auth.web.api;

import com.learn.auth.domain.UaaUserPosition;
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
 * 用户-岗位信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-02-21
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles({"dev"})
public class UaaUserPositionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(get("/api/v1/uaa-user-positions"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void loadTest() throws Exception {
        String id = "";

        mockMvc.perform(get("/api/v1/uaa-user-positions/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void createTest() throws Exception {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();

        mockMvc.perform(post("/api/v1/uaa-user-positions").content(uaaUserPosition.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();

        mockMvc.perform(put("/api/v1/uaa-user-positions").content(uaaUserPosition.toString()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    public void deleteTest() throws Exception {
        String id = "";

        mockMvc.perform(delete("/api/v1/uaa-user-positions/" + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

}
