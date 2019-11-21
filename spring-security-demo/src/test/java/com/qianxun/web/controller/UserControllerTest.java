package com.qianxun.web.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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

}
