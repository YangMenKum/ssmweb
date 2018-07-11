package ssm.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration
public class UserControllerTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectUser() {
        String responseString = null;   //将相应的数据转换为字符串
        try {
            responseString = mockMvc.perform
                    (
                            get("/user/showUser.do")          //请求的url,请求的方法是get
                                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)//数据的格式
                                    .param("id","1")   //添加参数(可以添加多个)
                                    //.param("id","3")   //添加参数(可以添加多个)
                    )
                    .andExpect(status().isOk())    //返回的状态是200
                    .andDo(print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----返回的json = " + responseString);
    }
}