package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.mockmvc.MockMvcFactory;
import com.divae.celebrity.databackend.services.ImageReaderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImageControllerUnitTest {

    private MockMvc mockMvc;

    private final ImageReaderService imageReaderService = mock(ImageReaderService.class);

    @Before
    public void setUp() {
        ImageController imageController = new ImageController(imageReaderService);
        mockMvc = MockMvcFactory.create(imageController);
    }

    
    @Test
    public void getImageFoundNothing() throws Exception {

        when(imageReaderService.getImageFromResourcesBy("notexistingid")).thenReturn(null);


        mockMvc.perform(MockMvcRequestBuilders.get("/images/notexistingid"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}