package com.rightkarma.learnjava.hibernate.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Employee implements Serializable {
    private int employeeId;
    private String name;
    private String emailId;
    private HiringData hiringData;
    private EmployeeMnpi employeeMnpi;
    private Collection<EmployeeHistory> employeeHistory = new ArrayList<>();
    private List<EmployeeProject> employeeProjects = new ArrayList<>();

    public Employee() {
    }

    public Employee(int employeeId, String name,
                    String emailId, Date hireDate, int hiringManagerId, Date dob) {
        this.employeeId=employeeId;
        this.name=name;
        this.emailId = emailId;
        this.hiringData = new HiringData(hireDate, hiringManagerId);
        this.setEmployeeMnpi(new EmployeeMnpi(dob));
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

    public EmployeeMnpi getEmployeeMnpi() {
        return employeeMnpi;
    }

    public void setEmployeeMnpi(EmployeeMnpi employeeMnpi) {
        this.employeeMnpi = employeeMnpi;
        this.employeeMnpi.setEmployee(this);
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
}