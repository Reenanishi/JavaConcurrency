package com.JavaThreads;

import java.security.SecureRandom;
import java.util.*;


// Task class to be executed (Step 1)
class Task implements Runnable
{
    private final String taskName;
    private final int sleepTime;
    private final Vector<Double> queue;
    private final Vector<Integer> sizeRecord;
    private static final SecureRandom generator = new SecureRandom();
    private final Double doubleStart;
    private final Double doubleEnd;



    public Task(String taskName, Double doubleStart, Double doubleEnd, int sleepTime,  Vector<Double> queue, Vector<Integer> sizeRecord)
    {
        this.taskName = taskName;
        this.sleepTime = sleepTime; // ms // 0 to 5 sec
        this.doubleStart = doubleStart;
        this.doubleEnd = doubleEnd;
        this.queue = queue;
        this.sizeRecord = sizeRecord;
    }

    @Override
    public void run()
    {
        try
        {
            while (true) {
                Double value = generator.nextDouble(doubleStart, doubleEnd);
                queue.add(value);

                System.out.printf("%s : Generated double is %.2f %n", taskName, value);
                System.out.printf("%s : Going to sleep for %d milliseconds.%n", taskName, sleepTime);
                Thread.sleep(sleepTime);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.printf("%s : Done sleeping%n", taskName);
    }
}