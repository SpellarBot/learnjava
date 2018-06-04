package com.rightkarma.effectivejava.publicanddefault.t2;

import com.rightkarma.effectivejava.publicanddefault.t1.C1I;

public class C2 {
    private C1I c1;

    public C1I getC1() {
        return c1;
    }

    public void setC1(C1I c1) {
        this.c1 = c1;
    }

    public void doit() {
        System.out.println(c1.toString());
    }
}
