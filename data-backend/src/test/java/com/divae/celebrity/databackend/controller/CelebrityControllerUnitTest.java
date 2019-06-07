package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.mockmvc.MockMvcFactory;
import com.divae.celebrity.databackend.model.CelebrityModel;
import com.divae.celebrity.databackend.services.CelebrityReaderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CelebrityControllerUnitTest {

    private MockMvc mockMvc;

    private final CelebrityReaderService celebrityReaderService = mock(CelebrityReaderService.class);

    @Before
    public void setUp() {
        CelebrityController celebrityController = new CelebrityController(celebrityReaderService);
        mockMvc = MockMvcFactory.create(celebrityController);
    }


    @Test
    public void getCelebrity() throws Exception {

        when(celebrityReaderService.getCelebrityFromDiskBy("123")).thenReturn(new CelebrityModel());


        mockMvc.perform(MockMvcRequestBuilders.get("/get-celebrity/123"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getCelebrityFoundNothing() throws Exception {

        when(celebrityReaderService.getCelebrityFromDiskBy("foo-notavailable")).thenReturn(null);


        mockMvc.perform(MockMvcRequestBuilders.get("/get-celebrity"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}