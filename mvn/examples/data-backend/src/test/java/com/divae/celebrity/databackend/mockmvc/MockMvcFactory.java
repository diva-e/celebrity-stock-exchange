package com.divae.celebrity.databackend.mockmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

public class MockMvcFactory {

    public static MockMvc create(Object controller) {
        return createBasicMockMvcBuilder(controller).build();
    }

    private static StandaloneMockMvcBuilder createBasicMockMvcBuilder(Object controller) {
        final Jackson2ObjectMapperFactoryBean objectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        objectMapperFactoryBean.setSimpleDateFormat("yyyy-MM-dd");
        objectMapperFactoryBean.afterPropertiesSet();
        final ObjectMapper objectMapper = objectMapperFactoryBean.getObject();
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setObjectMapper(objectMapper);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        return MockMvcBuilders.standaloneSetup(controller).setMessageConverters(jacksonConverter, stringHttpMessageConverter);
    }
}
