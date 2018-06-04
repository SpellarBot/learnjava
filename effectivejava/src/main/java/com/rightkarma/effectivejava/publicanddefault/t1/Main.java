package com.rightkarma.effectivejava.publicanddefault.t1;

import com.rightkarma.effectivejava.publicanddefault.t2.C2;

public class Main {
    public static void main(String[] args) {
        C1I c1 = new C1();
        C2 c2 = new C2();
        c2.setC1(c1);
        c2.doit();
    }
}
