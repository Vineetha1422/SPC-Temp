package com.g3.spc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcApplication.class, args);
		System.out.println("Working OK!");
	}
	
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("School Parent Communication App").description("contains api to provide services to parent,teacher and admin")
				.version("spcAppV1.1").build();
	}

}
