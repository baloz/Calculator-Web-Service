package com.tw.calculator;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAdd() throws Exception {

        String json = "{\"valueOne\":10,\"valueTwo\":20}";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON).content(json);
        MvcResult mvcResult = mockMvc.perform(
                requestBuilder
        ).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals("30.0", actual);
    }

}