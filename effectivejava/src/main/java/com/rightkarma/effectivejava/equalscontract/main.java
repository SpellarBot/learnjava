package com.rightkarma.effectivejava.equalscontract;

public class main {

    public static void main(String[] args) {
        main m = new main();
        m.run();
    }

    private void run() {
        Point p = new Point(1, 2);
        Point cp = new ColorPoint(1, 2, 3);

        System.out.println(p.equals(cp)); // true
        System.out.println(cp.equals(p)); // false
    }
}

/* LearningNote - we are looking at OOP issue.
For Point and ColorPoint class, if you
override equals in ColorPoint, then System.out.println(cp.equals(p)); will always be false.
don't override equals in ColorPoint, then you will be using equals from Point class.
    Issue with that is that it ignores a property defined in ColorPoint.
    THis is wrong as 2 colorpoint objects with different "z" value would also match if x and y match.

*/

