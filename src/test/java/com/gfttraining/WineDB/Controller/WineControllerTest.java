package com.gfttraining.WineDB.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfttraining.WineDB.Model.Wine;
import com.gfttraining.WineDB.Service.WineService;

@WebMvcTest(WineController.class)
public class WineControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    WineService wineService;

    Wine wine1 = new Wine();

    @Test
    void testFindById() throws Exception {

        Mockito.when(wineService.findById(1)).thenReturn(wine1);

        mockMvc.perform(MockMvcRequestBuilders
        .get("http://localhost8080/api/wine/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("nameTest")))
        .andExpect(jsonPath("$.year", is(1)));
    }

    @Test
    void testCreateWine() throws Exception{
        Mockito.when(wineService.createWine(wine1)).thenReturn(wine1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
        .post("http://localhost8080/api/wine")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(this.mapper.writeValueAsString(wine1));

        mockMvc.perform(mockRequest)
        .andExpect(status().isCreated());
        
    }
}
