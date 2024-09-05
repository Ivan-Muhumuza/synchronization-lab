package com.exercise;

public class DeadlockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock 2.");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock 1.");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();

        Thread t1 = new Thread(() -> demo.method1());
        Thread t2 = new Thread(() -> demo.method2());

        t1.start();
        t2.start();
    }
}

