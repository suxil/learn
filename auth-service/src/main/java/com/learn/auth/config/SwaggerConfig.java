package com.learn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket authServiceRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Spring Boot 使用 Swagger2 构建 REST API")
                .contact(new Contact("luxq", "url", "email"))
                .version("1.0")
                .description("权限 API")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learn.auth.web"))
                .paths(PathSelectors.any())
                .build();
    }

}
