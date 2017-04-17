package com.mitrais.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringtesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtesApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx){
		return args->{
			System.out.print("all beans");
			String[] beanNames=ctx.getBeanDefinitionNames();
			for(String beanName:beanNames){
				System.out.print(beanName);
			}
		};
	}*/
	@Bean
	public CommandLineRunner printMessage(HelloWorld component){
		return args->{
			component.setMessage("hello component");
			component.printMessage();
		};
	}
}
