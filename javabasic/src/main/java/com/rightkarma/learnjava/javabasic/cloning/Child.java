package com.rightkarma.learnjava.javabasic.cloning;

public class Child implements Cloneable {
    private String childName;

    public Child(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childName='" + childName + '\'' +
                '}';
    }

    @Override
    public Child clone(){
        try {
            return (Child) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
