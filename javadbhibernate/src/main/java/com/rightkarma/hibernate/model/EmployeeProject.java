package com.rightkarma.hibernate.model;

import java.util.Date;

public class EmployeeProject {
    private Employee employee;
    private int projectId;
    private Date startDate;
    private Date endDate;

    public EmployeeProject(int i, Date startDate, Date endDate) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EmployeeProject() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "EmployeeProject{" +
                ", projectId=" + projectId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
