package com.rightkarma.effectivejava.publicanddefault.t2;

import com.rightkarma.effectivejava.publicanddefault.t1.IClassOne;

public class ClassTwo {
    private IClassOne classOne;

    public IClassOne getClassOne() {
        return classOne;
    }

    public void setClassOne(IClassOne classOne) {
        this.classOne = classOne;
    }

    public void printString() {
        System.out.println(classOne.toString());
    }
}
