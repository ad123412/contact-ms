package com.digital.cmi.contactms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.reactive.config.EnableWebFlux;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableSwagger2
public class ContactmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactmsApplication.class, args);
    }

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.digital.cmi.contactms.controller"))
                .paths(regex("/account.*"))
                .build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Account Contact System API")
                .description("Purpose is to generate contact microservices system api responses")
                .build();
    }


}
