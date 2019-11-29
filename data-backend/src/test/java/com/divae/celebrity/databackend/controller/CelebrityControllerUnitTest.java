package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.mockmvc.MockMvcFactory;
import com.divae.celebrity.databackend.model.CelebrityModel;
import com.divae.celebrity.databackend.services.CelebrityFetcherService;
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
    private final CelebrityFetcherService celebrityFetcherService = mock(CelebrityFetcherService.class);

    @Before
    public void setUp() {
        CelebrityController celebrityController = new CelebrityController(celebrityReaderService, celebrityFetcherService);
        mockMvc = MockMvcFactory.create(celebrityController);
    }


    @Test
    public void getCelebrity() throws Exception {

        when(celebrityReaderService.getCelebrityFromResourcesBy("existingid")).thenReturn(new CelebrityModel());


        mockMvc.perform(MockMvcRequestBuilders.get("/get-celebrity/existingid"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getCelebrityFoundNothing() throws Exception {

        when(celebrityReaderService.getCelebrityFromResourcesBy("notexistingid")).thenReturn(null);


        mockMvc.perform(MockMvcRequestBuilders.get("/celebrities/notexistingid"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}
