package com.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LocksAndConditionsDemo {
    private Lock lock = new ReentrantLock(); // Reentrant lock allows a thread to acquire the same lock multiple times without causing a deadlock.

    /**
     * This creates a Condition object associated with the lock. The Condition provides methods like await() `suspend execution`
     * and signal() `notified by another thread` to coordinate the execution of threads.
     * Threads can wait for a condition to be met or signal other waiting threads to continue. **/
    private Condition condition = lock.newCondition();
    private boolean isAvailable = false; // This is a flag used to represent the condition that the thread is waiting for.
                                        // If isAvailable is false, the thread will wait; once it's true, the thread can proceed.

    public void await() throws InterruptedException {
        lock.lock(); // Explicitly acquire the lock
        try {
            while (!isAvailable) { // Check if the condition is met
                System.out.println("Waiting...");
                condition.await(); // The thread waits until another thread signals the condition
            }
            System.out.println("Proceeding...");
        } finally {
            lock.unlock(); // Ensure the lock is released even if an exception occurs
        }
    }

    public void signal() {
        lock.lock();
        try {
            isAvailable = true;
            condition.signal();
            System.out.println("Signaled...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LocksAndConditionsDemo demo = new LocksAndConditionsDemo();

        Thread t1 = new Thread(() -> {
            try {
                demo.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(demo::signal);

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}

