package com.rightkarma.learnjava.javabasic.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringSwitch {
    static Random randomNum = new Random();
    static List<Person> people = createPersonList();

    private static void demoSwtich() {
        int index = randomNum.nextInt(3); // // LearningNote - usage of Random class . 3 will not come.. this will give 0,1,2
        System.out.println(index);
        Person p = people.get(index);

        // LearningNote - String based swtich statement
        switch (p.getName()) {
            case "A":
                System.out.println("found A"); break;
            case "B":
                System.out.println("found B"); break;
            case "C":
                System.out.println("found C"); break;
            default:
                System.out.println("whose that ?");
        }
    }

    private static List<Person> createPersonList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A"));
        list.add(new Person("B"));
        list.add(new Person("C"));
        return list;
    }

    static class Person {
        private String name;
        public String getName() {
            return name;
        }

        public Person(String name) { this.name = name;}
        @Override
        public String toString() {
            return "Person [name=" + name + "]";
        }
    }
}
