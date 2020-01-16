package com.rafaelrahn.demospringrrr.personnel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonnelController.class)
public class PersonnelControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonnelService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.ping()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/personnel/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}
