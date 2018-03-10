package com.rightkarma.learnjava.threads.locks;

import java.util.Date;

public class ClassWithMethods {


    public synchronized void syncMethod1() {
        System.out.println("syncMethod1 is running");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
    }

    public synchronized void syncMethod2() {
        System.out.println("syncMethod2 is running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ClassWithMethods classWithMethods = new ClassWithMethods();
        Thread t1 = new Thread() {
            public void run() {
                classWithMethods.syncMethod1();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                classWithMethods.syncMethod2();
            }
        };

        t1.start();
        t2.start();

        /**
         * LearningNote
         * Experiment:
         * In a class if there are 2 methods that are synchronized, then only one method can run at a time.
         * Synchronize would cause lock at Class Object level.
         * Here we create one object, give it 2 threads which run 2 sync methods in parallel.
         * If thread status printed , one of them is RUNNABLE, other one is BLOCKED.
         */
        System.out.println("t1 syncMethod1 " + t1.getState().toString() );
        System.out.println("t2 syncMethod2 " + t2.getState().toString() );
    }
}

/*
OUTPUT

syncMethod1 is running
t1 syncMethod1 RUNNABLE
t2 syncMethod2 BLOCKED
syncMethod2 is running
*/
