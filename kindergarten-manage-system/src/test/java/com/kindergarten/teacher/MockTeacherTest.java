package com.kindergarten.teacher;

import com.alibaba.fastjson2.JSON;
import com.github.javafaker.Faker;
import com.kindergarten.student.entity.Student;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.dto.TeacherPageDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.kindergarten.teacher.mapper.TeacherMapper;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
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
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;

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

    @Test
    public void teacher() {
        Faker faker = new Faker(Locale.CHINA);

        for (int i = 0; i < 5; i++) {
            Teacher teacher = new Teacher();
            teacher.setName(faker.name().name());
            teacher.setAge(20 + (int) (Math.random() * (30 + 1 - 20)));
            teacher.setBiography(LocalDate.now().plusYears(-i + 10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            teacher.setGender(2);
            teacher.setHobbyTag("唱歌跳舞");
            teacher.setBiography("作为一名教师,我一直严格要求自己,务实求真,始终把教书育人当作自己的第一要务。");
            teacherMapper.insert(teacher);
        }
    }

    @Test
    public void student() {
        Faker faker = new Faker(Locale.CHINA);

        for (int i = 0; i < 30; i++) {
            Student teacher = new Student();
            teacher.setName(faker.name().name());
            teacher.setAge(5 + (int) (Math.random() * (14 + 1 - 5)));
            teacher.setBirthday(new Date());
            teacher.setGender(2);
            teacher.setGuardianName(faker.name().name());
            teacher.setGuardianPhone(faker.phoneNumber().phoneNumber());
            studentMapper.insert(teacher);
        }
    }
}
