package com.rightkarma.effectivejava.generics;

import java.util.HashSet;
import java.util.Set;

public class Generic {
    public Generic() {
    }

    public <T> Generic(Set<T> s1){
        for (T t:s1 ){
            System.out.println(t);
        }
    }

    public void questionMark(Set<?> s1){
        for (Object o:s1 ){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Generic g = new Generic();
        Set<String> s = new HashSet();
        s.add("A");
        Set<Integer> s2 = new HashSet();
        s2.add(23);
        g.questionMark(s);
        g.questionMark(s2);
    }
}
