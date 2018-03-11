package com.rightkarma.learnjava.jaxb;

import java.util.ArrayList;
import java.util.List;

public class Department{
    String name;
    String description;
    List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
