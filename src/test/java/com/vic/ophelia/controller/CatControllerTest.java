package com.vic.ophelia.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author vicdor
 * @create 2018-02-07 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {
    @Resource
    private MockMvc mockMvc;

    @Test
    public void cats() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cat/cats"))
                //.andExpect(MockMvcResultMatchers.content().string("abc"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}