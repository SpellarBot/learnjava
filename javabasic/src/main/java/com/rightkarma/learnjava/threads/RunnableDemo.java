package com.rightkarma.learnjava.threads;

// LearningNote - simple class to show Runnable Interface
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("App thread name: " + name);
        int i = 5;
        while (i > 0) {
            System.out.println(name + " thread running..i: " + i);
            i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("THREAD EXCEPTION. Thread:" + name);
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        RunnableDemo r = new RunnableDemo();
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        int x = 2;
        while (x > 0) {
            System.out.println("Start running thread.....");
            System.out.println(".................................");
            r.run(); // this will run code on main thread.
            x--;
        }
    }
}

/*OUTPUT

Main thread name: main
Start running thread.....
.................................
App thread name: main
main thread running..i: 5
main thread running..i: 4
main thread running..i: 3
main thread running..i: 2
main thread running..i: 1
Start running thread.....
.................................
App thread name: main
main thread running..i: 5
main thread running..i: 4
main thread running..i: 3
main thread running..i: 2
main thread running..i: 1

* */
