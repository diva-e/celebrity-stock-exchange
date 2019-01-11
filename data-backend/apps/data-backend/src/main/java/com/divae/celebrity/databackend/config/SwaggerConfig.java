package com.divae.celebrity.databackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        final Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();

        docket.useDefaultResponseMessages(false);

        List<ResponseMessage> responseMessages = configureGlobalResponses();

        docket.globalResponseMessage(RequestMethod.GET, responseMessages);
        docket.globalResponseMessage(RequestMethod.PUT, responseMessages);
        docket.globalResponseMessage(RequestMethod.POST, responseMessages);
        docket.globalResponseMessage(RequestMethod.DELETE, responseMessages);


        return docket;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Celebrity Data Backend",
                "",
                "1.0",
                "",
                new Contact("Hawaii-Team", "https://intranet.netpioneer.de/display/Orga/Teamentwicklung+Hawaii", "team-hawaii@diva-e.com"),
                "",
                "",
                Collections.emptyList());
        return apiInfo;
    }

    private List<ResponseMessage> configureGlobalResponses() {
        ResponseMessage globalResponseUnauthorized = new ResponseMessageBuilder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .message("Unauthorized access to REST API. Basic Authentication must be provided.")
                .build();

        ResponseMessage globalResponseForbidden = new ResponseMessageBuilder()
                .code(HttpStatus.FORBIDDEN.value())
                .message("Forbidden")
                .build();

        ResponseMessage globalResponseNotFound = new ResponseMessageBuilder()
                .code(HttpStatus.NOT_FOUND.value())
                .message("Not Found")
                .build();

        return Arrays.asList(globalResponseUnauthorized, globalResponseForbidden, globalResponseNotFound);
    }

}
