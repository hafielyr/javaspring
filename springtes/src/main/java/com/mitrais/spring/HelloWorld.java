package com.mitrais.spring;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	private String message;
	
	public void setMessage(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}
	public void printMessage(){
		System.out.println("your message: "+message);
	}
}
