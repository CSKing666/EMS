package com.model;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String password;
	private int age;
	
	public enum Gender{
		male,
		female,
		others
	};
	
	private Gender gender;
	private String mobile;
	private String department;
	private String Address;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Employee(int id, String name, String email, String password, int age, Gender gender, String mobile,
			String department, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.department = department;
		Address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", gender=" + gender + ", mobile=" + mobile + ", department=" + department + ", Address=" + Address
				+ "]";
	}
	
	
}
