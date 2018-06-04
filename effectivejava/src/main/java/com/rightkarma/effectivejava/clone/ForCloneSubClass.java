package com.rightkarma.effectivejava.clone;

public class ForCloneSubClass extends ForClone implements Cloneable {
    private int id;

    public ForCloneSubClass(int id) {
        super(id);
        this.id = id;
    }

    public ForCloneSubClass clone()throws CloneNotSupportedException{
        return (ForCloneSubClass) super.clone();
    }

    @Override
    public String toString() {
        return "ForCloneSubClass{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        ForCloneSubClass forCloneSubClass=new ForCloneSubClass(1);
        try {
            ForCloneSubClass clone = (ForCloneSubClass) forCloneSubClass.clone();
            System.out.println("class:"+forCloneSubClass.getClass()+"-"+forCloneSubClass);
            System.out.println("class:"+clone.getClass()+"-"+clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
