package com.mitrais.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	private List<Employee> employee;
	private List<Employee> result;
	public List<Employee> getResult() {
		return result;
	}

	public void setResult(Employee result) {
		this.result.add(result);
	}

	public EmployeeController() {
		employee = new ArrayList<Employee>();
		result=new ArrayList<Employee>();
		Employee e1=new Employee("male","1");
		Employee e2=new Employee("female","2");
		this.employee.add(e1);
		this.employee.add(e2);
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	@ResponseBody
	public List<Employee> employeesHello(@RequestParam
    String gender){
		for(Employee e:employee){
			if(e.getGender().equals(gender)){
				result.add(e);
			}
		}
		return result;
	}
	@RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getEmployee(@PathVariable String id){
		String result=null;
		for(Employee e:employee){
			if(e.ID.equals(id)){
				result=e.getGender();
				return result;
			}
			
		}
		if(result==null){
			throw new EmployeeNotFoundException();
		}
		return result;
	}
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	@ResponseBody
	public Employee employeeHello(
			@RequestBody Employee gender
			){
		
		return gender;
	}
	
}
