package com.rightkarma.learnjava.spring.model;

public class Customer {
    private String firsname;
    private String lastname;

    public Customer() {
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firsname='" + firsname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
