package com.rightkarma.effectivejava.clone;

public class ForClone implements Cloneable {
    private int id;

    public ForClone(int id) {
        this.id = id;
    }

    public ForClone clone()throws CloneNotSupportedException{
        return (ForClone) super.clone();
    }

    @Override
    public String toString() {
        return "ForClone{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        ForClone forClone=new ForClone(1);
        try {
            ForClone clone = (ForClone) forClone.clone();
            System.out.println("class:"+forClone.getClass()+"-"+forClone);
            System.out.println("class:"+clone.getClass()+"-"+clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
