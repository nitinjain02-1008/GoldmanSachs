package com.Interview.Problem.model;

public class Employee {
	
	int id;
	String name;
	int age;
	double sal;
	String dept;
	
	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param sal
	 * @param dept
	 */
	public Employee(int id, String name, int age, double sal, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
		this.dept = dept;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + ", dept=" + dept + "]";
	}
	
}
