package com.rest.webservice.restfulwebservicess;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@ComponentScan(basePackages = "com.rest.webservices.restfulwebservices.helloworld")
public class RestfulWebServicessApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicessApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolvers() {

		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
