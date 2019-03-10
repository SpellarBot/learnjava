package com.rightkarma.learnjava.javabasic.cloning;

public class Person implements Cloneable {
    private String name;
    private Child child;
    private AnotherChildNonCloneable anotherChildNonCloneable;

    public Person(String name, Child child, AnotherChildNonCloneable anotherChildNonCloneable) {
        this.name = name;
        this.child=child;
        this.anotherChildNonCloneable=anotherChildNonCloneable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child getChild() {
        return child;
    }

    public AnotherChildNonCloneable getAnotherChildNonCloneable() {
        return anotherChildNonCloneable;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", child=" + child +
                ", anotherChildNonCloneable=" + anotherChildNonCloneable +
                '}';
    }

    @Override
    public Person clone() {
        try {
            Person p = (Person) super.clone();
            p.child=child.clone(); //NOTE - Any objects need to be cloned manually in Clone method
            return p;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Person p = new Person("A", new Child("C"), new AnotherChildNonCloneable("AnotherChild AC"));
        Person p2 = p.clone();
        p2.getChild().setChildName("C2"); // here we know p2 had a cloned Child object and not the original. so expect different names in print.
        p2.getAnotherChildNonCloneable().setChildName("AC2"); // AnotherChild is not cloned, so original object is modified, so name will change for p also
        System.out.println(p);
        System.out.println(p2);

    }
}
