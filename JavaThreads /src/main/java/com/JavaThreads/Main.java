package com.JavaThreads;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {

        final Vector<Double> queue1 = new Vector<>();
        final Vector<Integer> sizeRecord1 = new Vector<>();
        final Vector<Double> queue2 = new Vector<>();
        final Vector<Integer> sizeRecord2 = new Vector<>();
        final Vector<Double> queue3 = new Vector<>();
        final Vector<Integer> sizeRecord3 = new Vector<>();
        final Vector<Double> queue4 = new Vector<>();
        final Vector<Integer> sizeRecord4 = new Vector<>();
        final Vector<Double> queue5 = new Vector<>();
        final Vector<Integer> sizeRecord5 = new Vector<>();

        Runnable task1 = new Task("task1", Double.valueOf(5), Double.valueOf(10), 1000, queue1, sizeRecord1);
        Runnable task2 = new Task("task2", Double.valueOf(15), Double.valueOf(20), 2000, queue2, sizeRecord2);
        Runnable task3 = new Task("task3", Double.valueOf(25), Double.valueOf(30), 3000, queue3, sizeRecord3);
        Runnable task4 = new Task("task4", Double.valueOf(35), Double.valueOf(40), 4000, queue4, sizeRecord4);
        Runnable task5 = new Task("task5", Double.valueOf(45), Double.valueOf(50), 5000, queue5, sizeRecord5);
        Runnable task6 = new SortingTask("task6", queue1, sizeRecord1, queue2, sizeRecord2, queue3, sizeRecord3,
                queue4, sizeRecord4, queue5, sizeRecord5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.execute(task5);
        executorService.execute(task6);

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            executorService.shutdownNow();

            System.out.println("Final report");
            System.out.println("Queue 1 size = " + queue1.size());
            System.out.println("Extent queue 1 sorted = " + sizeRecord1);
            System.out.println("Queue 2 size= " + queue2.size());
            System.out.println("Extent queue 2 sorted = " + sizeRecord2);
            System.out.println("Queue 3 size = " + queue3.size());
            System.out.println("Extent queue 3 sorted = " + sizeRecord3);
            System.out.println("Queue 4 size = " + queue4.size());
            System.out.println("Extent queue 4 sorted = " + sizeRecord4);
            System.out.println("Queue 5 size = " + queue5.size());
            System.out.println("Extent queue 5 sorted = " + sizeRecord5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");
    }
}