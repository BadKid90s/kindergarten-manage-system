package com.kindergarten.teacher;

import com.alibaba.fastjson2.JSON;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.dto.TeacherPageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author lxcecho 909231497@qq.com
 * @since 14:14 11-12-2022
 */
@SpringBootTest(properties = "spring.profiles.active=local")
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Slf4j
public class MockTeacherTest {

    @Autowired
    private MockMvc mockMvc;

    private TeacherDTO teacherDTOSave;

    private TeacherDTO teacherDTOModify;

    private TeacherDTO teacherDTODelete;

    private TeacherPageDTO teacherPageDTO;

    @Before
    public void init() {
        this.teacherDTOSave = new TeacherDTO()
                .setName("AA" + UUID.randomUUID().toString().substring(0, 3))
                .setAge((int) (Math.random() * 100) + 10)
                .setHobbyTag("rua cat and dog")
                .setBiography("不羁放纵爱自由");

        this.teacherDTOModify = new TeacherDTO()
                .setId(3L)
                .setName("lxcecho")
                .setAge(111)
                .setHobbyTag("rua cat and dog")
                .setBiography("不羁放纵爱自由1111");

        this.teacherDTODelete = new TeacherDTO()
                .setIds(Arrays.asList(3L, 4L, 5L));

        this.teacherPageDTO = new TeacherPageDTO().setPageNum(1).setPageSize(3);
    }

    @Test
    public void testSaveController() throws Exception {

        String url = "http://localhost:8080/teacher/teacher/save";

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(teacherDTOSave))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void testModifyController() throws Exception {
        String url = "http://localhost:8080/teacher/teacher/modify";

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(teacherDTOModify))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void testDeleteController() throws Exception {
        String url = "http://localhost:8080/teacher/teacher/delete";

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(teacherDTODelete))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void testListController() throws Exception {
        String url = "http://localhost:8080/teacher/teacher/list";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(teacherPageDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        log.debug("result: {}", result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
