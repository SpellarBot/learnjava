package com.rightkarma.hibernate.model;

import java.util.*;

public class Employee {
    private int employeeId;
    private String name;
    private String emailId;
    private HiringData hiringData;
    private Collection<EmployeeHistory> employeeHistory = new ArrayList<>();
    private List<EmployeeProject> employeeProjects = new ArrayList<>();
    private EmployeeMnp employeeMnp;

    public Employee() {
    }

    public Employee(int employeeId, String name,
                    String emailId, Date hireDate, int hiringManagerId) {
        this.employeeId=employeeId;
        this.name=name;
        this.emailId = emailId;
        this.hiringData = new HiringData(hireDate, hiringManagerId);
    }

    public Collection<EmployeeHistory> getEmployeeHistory() {
        return employeeHistory;
    }

    public void setEmployeeHistory(Collection<EmployeeHistory> employeeHistory) {
        this.employeeHistory = employeeHistory;
    }
    public List<EmployeeProject> getEmployeeProjects() {
        return employeeProjects;
    }

    public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public EmployeeMnp getEmployeeMnp() {
        return employeeMnp;
    }

    public void setEmployeeMnp(EmployeeMnp employeeMnp) {
        this.employeeMnp = employeeMnp;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public HiringData getHiringData() {
        return hiringData;
    }

    public void setHiringData(HiringData hiringData) {
        this.hiringData = hiringData;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", hiringData=" + hiringData +
                "} ");
        sb.append(System.lineSeparator());
        sb.append(" HISTORY: ");
        for ( EmployeeHistory eh: this.getEmployeeHistory()){
            sb.append(eh);
            sb.append(" | ");
        }
        sb.append(System.lineSeparator());
        sb.append(" PROJECTS: ");
        for ( EmployeeProject ep: this.getEmployeeProjects()){
            sb.append(ep);
            sb.append(" | ");
        }
        return sb.toString();
    }

    public void addProject(EmployeeProject employeeProject){
        employeeProject.setEmployee(this);
        employeeProjects.add(employeeProject);
    }
    public void addMnp(EmployeeMnp mnp){
        mnp.setEmployee(this);
        employeeMnp=mnp;
    }
}