package com.rightkarma.learnjava.jaxb.annotation;

import javax.xml.bind.annotation.*;
import java.util.Date;

public class Employee{

    @XmlElement(required = true)
    int id;
    String name;
    Date dob;

    public Employee() {
    }

    public Employee(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
