package com.mitrais.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringtesApplicationTests {
	
	
	private MockMvc mockMvc;
	private MockMvc mockMvc2;
	
	@Test
	public void contextLoads() {
	}
	@Before
	public void setup(){
		this.mockMvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
		this.mockMvc2=MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}
	@Test
	public void getMessage() throws Exception{
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk());
	}
	@Test
	public void getMessage2()throws Exception{
		String result = "[{\"gender\": \"male\",\"ID\": \"1\"}]";
		this.mockMvc2.perform(get("/employees?gender=male")).andExpect(status().isOk()).andExpect(content().json(result));
	}
	@Test
	public void getMessage3() throws Exception{
		String result = "{\"gender\": \"male\",\"ID\": \"1\"}";
		this.mockMvc2.perform(post("/employees").content("{\"gender\":\"male\",\"ID\":\"1\"}").contentType("application/json")).andExpect(status().isOk());
	}
	@Test
	public void shouldReturnNotFound() throws Exception{
		this.mockMvc2.perform(get("/employees/3")).andExpect(status().isNotFound());
	}
}
