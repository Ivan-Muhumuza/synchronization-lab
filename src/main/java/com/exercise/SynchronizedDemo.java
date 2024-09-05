package com.exercise;

public class SynchronizedDemo {
    private int counter = 0;

    // Synchronized method
    public synchronized void increment() {
        counter++;
    }

    // Synchronized block
    public void incrementWithBlock() {
        synchronized (this) {
            counter+=2;
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();

        // Create threads using synchronized method and blocks
        Thread t1 = new Thread(demo::increment);
        Thread t2 = new Thread(demo::incrementWithBlock);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value: " + demo.getCounter());
    }
}

