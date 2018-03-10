package com.rightkarma.learnjava.threads;

public class AppThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
        int i = 5;
        while (i > 0) {
            System.out.println(Thread.currentThread().getName() + " "+i--);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " InterruptedException: " + e.getMessage());
            }
        }
    }

    /**
     * LearningNote
     * Start a thread from main using start().
     * start() will run a seperate thread.
     * run() will run code on main thread even if you create a seperate thread object.
     * In Below code 2 threads should be running.
     * main - by default. It will first run psvm code, and then code assinged to thread t because of t.run()
     * Thread-0 - due to t.start()
     *
     *
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main method running");
        AppThread t = new AppThread();
        t.start();// this will start a new thread.
        t.interrupt();
        t.run();
        t.interrupt();
    }
}


/*
 * OUTPUT
main main method running
main running
main 5
Thread-0 running
Thread-0 5
Thread-0 InterruptedException: sleep interrupted
Thread-0 4
Thread-0 3
main 4
main 3
Thread-0 2
main 2
Thread-0 1
main 1

 * 
 */