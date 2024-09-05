package com.exercise;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesDemo {
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    public void increment() {
        atomicCounter.incrementAndGet();
    }

    public int getCounter() {
        return atomicCounter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicVariablesDemo demo = new AtomicVariablesDemo();

        // Create multiple threads
        Thread t1 = new Thread(demo::increment);
        Thread t2 = new Thread(demo::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Atomic Counter value: " + demo.getCounter());
    }
}

