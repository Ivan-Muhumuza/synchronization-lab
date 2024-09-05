package com.exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Synchronized Blocks and Methods Demo");
            System.out.println("2. Deadlock and Prevention Demo");
            System.out.println("3. Locks and Condition Variables Demo");
            System.out.println("4. Atomic Variables Demo");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Running Synchronized Blocks and Methods Demo...");
                    SynchronizedDemo.main(null);  // Call to SynchronizedDemo's main
                    break;
                case 2:
                    System.out.println("Running Deadlock and Prevention Demo...");
                    DeadlockDemo.main(null);  // Call to DeadlockDemo's main
                    break;
                case 3:
                    System.out.println("Running Locks and Condition Variables Demo...");
                    LocksAndConditionsDemo.main(null);  // Call to LocksAndConditionsDemo's main
                    break;
                case 4:
                    System.out.println("Running Atomic Variables Demo...");
                    AtomicVariablesDemo.main(null);  // Call to AtomicVariablesDemo's main
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
