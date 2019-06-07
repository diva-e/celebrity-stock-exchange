package com.divae.celebrity.databackend.services;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ImageReaderService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ImageReaderService.class);


    private final ObjectMapper objectMapper;

    public ImageReaderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public InputStreamResource getImageFromResourcesBy(String id) {
        InputStreamResource result = null;

        ClassPathResource imgFile = new ClassPathResource("images/" + id + ".jpg");

        if(imgFile.exists()) {
            try {

                result = new InputStreamResource(imgFile.getInputStream());

            } catch (IOException ex) {
                result = null;
            }
        }

        return result;
    }


}
