package com.demo.smartjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author alberto
 * Sep 17, 2024
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.smartjob"))
				.paths(PathSelectors.any()).build();
	}

	@SuppressWarnings({"deprecation"})
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Create User API")
				.description("API para alta de usuarios")
				.termsOfServiceUrl("http://en.wikipedia.org/wiki/Terms_of_service").contact("Alberto Niño")
				.license("Apache License Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0").build();
	}

}
