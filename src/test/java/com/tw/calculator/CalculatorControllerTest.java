package com.tw.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;


@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addEndpointTest() throws Exception {

        String json = "{\"valueOne\":10,\"valueTwo\":20}";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON).content(json);
        MvcResult mvcResult = mockMvc.perform(
                requestBuilder
        ).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals("30.0", actual);
    }


    @Test
    public void multiplyEndpointTest() throws Exception {

        String json = "{\"valueOne\":10,\"valueTwo\":20}";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/multiply")
                .contentType(MediaType.APPLICATION_JSON).content(json);
        MvcResult mvcResult = mockMvc.perform(
                requestBuilder
        ).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals("200.0", actual);
    }
    @Test
    public void divideEndpointTest() throws Exception {

        String json = "{\"valueOne\":20,\"valueTwo\":10}";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/divide")
                .contentType(MediaType.APPLICATION_JSON).content(json);
        MvcResult mvcResult = mockMvc.perform(
                requestBuilder
        ).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals("2.0", actual);
    }












}