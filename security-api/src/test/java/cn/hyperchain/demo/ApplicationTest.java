//package cn.hyperchain.demo;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
///**
// * File: ApplicationTest.java
// * Description:
// * Company:
// *
// * @Author: yyz
// * Datetime: 2021-01-14
// */
//@SpringBootTest
//public class ApplicationTest {
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void start(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    void hello() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON_UTF8))
//
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(mvcResult.getResponse());
//
//    }
//    @Test
//    void getApp() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getApp").contentType(MediaType.APPLICATION_JSON_UTF8))
//
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(mvcResult.getResponse());
//
//    }
//
//    @Test
//    void getAppById() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/get/2").contentType(MediaType.APPLICATION_JSON_UTF8))
//
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(mvcResult.getResponse());
//
//    }
//    @Test
//    void getAppById2() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getLog?id=1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content("id=1")
//                )
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(mvcResult.getResponse());
//
//    }
//    @Test
//    void login() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/login?name=admin&password=123456")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content("id=1")
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(mvcResult.getResponse());
//
//    }
//
//}
