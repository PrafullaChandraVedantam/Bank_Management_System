package com.microcredentialcourse.login.swagger;

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
public class Swagger2Config {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.microcredentialcourse"))
				.paths(PathSelectors.ant("/v1/*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("Swagger for Customer Login")
				.description("REST API for Customer Login")
				.contact(new Contact("Sree Krishna", "www.cognizant.com", "sreekrishna.vedantam@cognizant.com")).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}
}
//@Bean
//public Docket swaggerConfiguration() {
//	return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/users/*"))
//			.apis(RequestHandlerSelectors.basePackage("com.MicroCredentialProgram")).build().apiInfo(apiDetails());
//
//}
//
//private ApiInfo apiDetails() {
//	return new ApiInfo("Customer Registration and Login", "API for Customer Registration", "1.0", "SWagger Test",
//			new springfox.documentation.service.Contact("Sree", "http://swagger-ui.html", "abc.com"), "Api License",
//			"http://swagger-ui.html");
//
//}