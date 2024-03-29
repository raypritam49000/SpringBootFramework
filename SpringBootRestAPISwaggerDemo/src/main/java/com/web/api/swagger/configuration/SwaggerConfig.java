package com.web.api.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("ray").apiInfo(apiInfo()).select()
				.paths(regex("/student.*")).build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student API")
				
				.description("JavaInUse API reference for developers")
				
				.termsOfServiceUrl("http://AndrotechJava4U.com")
				
				.contact("raypritam420@gmail.com")
				
				.license("JavaInUse License")
				
				.licenseUrl("raypritam420@gmail.com").version("2.0").build();
	}

}
