package com.rightkarma.learnjava.hibernate.model;

import java.util.Date;

public class EmployeeMnpi {
    private int mnpiId;
    private Employee employee;
    private Date dob;

    public EmployeeMnpi(Date dob) {
        this.dob=dob;
    }

    @Override
    public String toString() {
        return "EmployeeMnpi{" +
                "mnpiId=" + mnpiId +
                ", employee=" + employee +
                ", dob=" + dob +
                '}';
    }

    public EmployeeMnpi() {
    }

    public int getMnpiId() {
        return mnpiId;
    }

    public void setMnpiId(int mnpiId) {
        this.mnpiId = mnpiId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
