package com.dj.servertool.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "tool", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) // 这里采用包含注解的方式来确定要显示的接口
				// .apis(RequestHandlerSelectors.basePackage("com.dj.servertool.modular.system.controller"))
				// //这里采用包扫描的方式来确定要显示的接口
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Guns Doc").description("Guns Api文档")
				.termsOfServiceUrl("https://gitee.com/stylefeng/guns")
				.contact(new Contact("stylefeng", "https://gitee.com/stylefeng/guns", "")).version("2.0").build();
	}

}
