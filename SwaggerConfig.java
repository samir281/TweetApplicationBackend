package com.tweetapp.tweet.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {
	
	public static final String Authorization_Header="Authorization";
	
	private ApiKey apikey()
	{
		return new ApiKey("JWT", Authorization_Header,"header");
	}
	
	private List<SecurityContext> securitycontext()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	private List<SecurityReference> sf()
	{
		AuthorizationScope scope=new AuthorizationScope("global","accesseverything");
		return Arrays.asList(new SecurityReference("JWT",
				new AuthorizationScope[] {scope}));
	}
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getinfo())
				.securityContexts(securitycontext()).securitySchemes(java.util.Arrays.asList(apikey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo getinfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("Tweet Application",
				"Tweet Application we can do like,comment and post a tweet",
				"1.0", 
				"Terms of service",
				new Contact("Md Samir Alam", "https://www.linkedin.com/in/md-samir-alam-1b87b6114/","linnkedin"),
				"Tech Acdemy ","TechAcedemy licence",Collections.emptyList());
	}
}
