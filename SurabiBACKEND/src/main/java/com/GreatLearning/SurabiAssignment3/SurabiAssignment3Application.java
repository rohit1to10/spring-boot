package com.GreatLearning.SurabiAssignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@SpringBootApplication(scanBasePackages={
//"com.GreatLearning.SurabiAssignment3.controller", "com.GreatLearning.SurabiAssignment3.dao" , "com.GreatLearning.SurabiAssignment3.entity"})
@SpringBootApplication
@ComponentScan("com.GreatLearning.SurabiAssignment3")
//@ComponentScan("com.GreatLearning.SurabiAssignment3.dao")
//@ComponentScan("com.GreatLearning.SurabiAssignment3.service")
//@ComponentScan("com.GreatLearning.SurabiAssignment3.controller")
public class SurabiAssignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(SurabiAssignment3Application.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/customer/create").allowedOrigins("http://localhost:4200");
				registry.addMapping("/customer/register").allowedOrigins("http://localhost:3000");
				registry.addMapping("/customer/billinsert/raj/500").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
