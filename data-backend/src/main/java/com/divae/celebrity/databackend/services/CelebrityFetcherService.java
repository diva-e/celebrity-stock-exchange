package com.divae.celebrity.databackend.services;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CelebrityFetcherService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CelebrityFetcherService.class);


    private final ObjectMapper objectMapper;

    public CelebrityFetcherService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public int[] getMentionsFromTwitter(String id) {
        return null;
    }

    public int[] getMentionsFromFacebook(String id) {
        return null;
    }

    public int[] getMentionsPerMonth() {
        return new int[]{0,0};
    }
}
