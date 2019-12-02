package com.qianxun.web.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-20 16:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void whenUploadSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("UTF-8"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenQuerySuccess() throws Exception{

        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username","liming")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                //期待返回结果状态为200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期待查询json数据user的个数为3
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))

        .andReturn().getResponse().getContentAsString();
        System.out.println(result);


    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenCreateSuccess() throws Exception {

        Date date = new Date();
        System.out.println(date.getTime());
        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        String reuslt = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(reuslt);
    }

    @Test
    public void whenUpdateSuccess() throws Exception {

        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(date.getTime());
        String content = "{\"id\":\"1\", \"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        String reuslt = mockMvc.perform(MockMvcRequestBuilders.put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(reuslt);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
