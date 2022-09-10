package com.tweetapp.tweet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class crosconfig implements WebMvcConfigurer{
	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }

}
