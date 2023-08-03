package com.codingtest.rgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class RgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RgtApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(
				"classpath:/messages/default-messages"
		);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(300);
		return messageSource;
	}

}
