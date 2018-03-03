package com.rightkarma.hibernate.model;

import java.util.Date;

public class EmployeeMnp {
    private int mnpId;
    private Employee employee;
    private Date dob;

    public EmployeeMnp() {
    }

    public EmployeeMnp(Date dob, Employee employee) {
        this.dob = dob;
        this.employee = employee;
    }

    public int getMnpId() {
        return mnpId;
    }

    public void setMnpId(int mnpId) {
        this.mnpId = mnpId;
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

    @Override
    public String toString() {
        return "EmployeeMnp{" +
                "dob=" + dob +
                '}';
    }
}
