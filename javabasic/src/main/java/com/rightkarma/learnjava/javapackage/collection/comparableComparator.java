package com.rightkarma.learnjava.javapackage.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparableComparator {

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(2, "Z"));
		emps.add(new Employee(1, "Q"));
		emps.add(new Employee(2, "E"));
		emps.add(new Employee(3, "I"));
		emps.add(new Employee(4, "P"));
		Collections.sort(emps);
		for (Employee e : emps){
			System.out.println(e.toString());
		}
		
		Collections.sort(emps, new sortEmployees());
		for (Employee e : emps){
			System.out.println(e.toString());
		}
	}
}
class sortEmployees implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	public Employee(int i, String string) {
		id=i;
		name=string;
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
	@Override
	public int compareTo(Employee o) {
		return this.id-o.id;
	}
	
}