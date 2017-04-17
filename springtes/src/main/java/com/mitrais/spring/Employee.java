package com.mitrais.spring;

public class Employee {
	private String gender;
	public String ID;
	
	public Employee(){
		
	}
	public Employee(String gender,String ID){
		this.gender=gender;
		this.ID=ID;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
