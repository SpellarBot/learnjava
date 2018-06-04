package com.rightkarma.effectivejava.clone;

// learn - for clone to work, mutable objects in a class must be non-final
// if final , and
// you don't create their clone, clone object would point to original object ( example array )
// you do create their clone, compiler will give error saying final object cant be reassigned

public class ForCloneComplex implements Cloneable {
    private Object[] elements;

    public ForCloneComplex() {
        this.elements = new Object[16];
    }

    @Override
    public ForCloneComplex clone(){
        try {
            ForCloneComplex clone = (ForCloneComplex) super.clone();
            clone.elements=elements.clone(); // learn - if elements is final, this statement will give error.
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
