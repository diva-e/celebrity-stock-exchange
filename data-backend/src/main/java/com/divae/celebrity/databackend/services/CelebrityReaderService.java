package com.divae.celebrity.databackend.services;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CelebrityReaderService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CelebrityReaderService.class);


    private final ObjectMapper objectMapper;

    public CelebrityReaderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public CelebrityModel getCelebrityFromResourcesBy(String id) {
        try {

            final InputStream is = this.getClass().getClassLoader().getResourceAsStream(id + ".json");
            final CelebrityModel celebrityModel = objectMapper.readValue(is, CelebrityModel.class);
            return celebrityModel;

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }


}
