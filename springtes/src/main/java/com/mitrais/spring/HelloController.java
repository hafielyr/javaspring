package com.mitrais.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	@ResponseBody
	public String hello(
			@RequestBody String message
			){
		return "Your message "+message;
	}
	@RequestMapping("/helloo")
	@ResponseBody
	public String hello2(
			 @RequestParam(value = "message", defaultValue = "Hello Spring")
		     String message
			){
		return "Your message "+message;
	}
	@RequestMapping(value="/hello/{message}", method=RequestMethod.PUT)
	@ResponseBody
	public String hello3(
			@PathVariable String message
			){
		return "Your message "+message;
	}
}
