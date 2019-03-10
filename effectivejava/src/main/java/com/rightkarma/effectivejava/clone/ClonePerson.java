package com.rightkarma.effectivejava.clone;

// learn - class has to implement Cloneable interfaces
// clone method would clone the String and other non-Object types
// any other objects are also cloned now
// you can override Clone method or skip it if you want to use the default


public class ClonePerson implements Cloneable {
    private int id;
    private String name;
    private SomeObject someObject;

    public ClonePerson(int id, String name, SomeObject someObject) {
        this.id = id;
        this.name = name;
        this.someObject = someObject;
    }

    @Override
    public String toString() {
        return "ClonePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", someObject=" + someObject +
                '}';
    }

    public static void main(String[] args) {
        ClonePerson clonePerson =new ClonePerson(1, "A", new SomeObject());
        try {
            ClonePerson clonePerson2 = (ClonePerson) clonePerson.clone();
            System.out.println("class:"+ clonePerson.getClass()+"-"+ clonePerson);
            System.out.println("class:"+ clonePerson2.getClass()+"-"+ clonePerson2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static class SomeObject {

    }
}
