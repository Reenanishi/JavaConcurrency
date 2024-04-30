package com.JavaThreads;

import java.security.SecureRandom;
import java.util.*;

class SortingTask implements Runnable
{
    private final String taskName;
    private final Vector<Double> queue1;
    private final Vector<Integer> sizeRecord1;
    private final Vector<Double> queue2;
    private final Vector<Integer> sizeRecord2;
    private final Vector<Double> queue3;
    private final Vector<Integer> sizeRecord3;
    private final Vector<Double> queue4;
    private final Vector<Integer> sizeRecord4;
    private final Vector<Double> queue5;
    private final Vector<Integer> sizeRecord5;
    private static final SecureRandom generator = new SecureRandom();

    public SortingTask(String taskName, Vector<Double> queue1, Vector<Integer> sizeRecord1,
                       Vector<Double> queue2, Vector<Integer> sizeRecord2,
                       Vector<Double> queue3, Vector<Integer> sizeRecord3,
                       Vector<Double> queue4, Vector<Integer> sizeRecord4,
                       Vector<Double> queue5, Vector<Integer> sizeRecord5)
    {
        this.taskName = taskName;
        this.queue1 = queue1;
        this.sizeRecord1 = sizeRecord1;
        this.queue2 = queue2;
        this.sizeRecord2 = sizeRecord2;
        this.queue3 = queue3;
        this.sizeRecord3 = sizeRecord3;
        this.queue4 = queue4;
        this.sizeRecord4 = sizeRecord4;
        this.queue5 = queue5;
        this.sizeRecord5 = sizeRecord5;
    }

    public synchronized  void sortQueueAndRecordLength() {
        System.out.printf("%s : Sorting started for all queues%n", taskName);

        Collections.sort(queue1);
        sizeRecord1.add(queue1.size());

        Collections.sort(queue2);
        sizeRecord2.add(queue2.size());

        Collections.sort(queue3);
        sizeRecord3.add(queue3.size());

        Collections.sort(queue4);
        sizeRecord4.add(queue4.size());

        Collections.sort(queue5);
        sizeRecord5.add(queue5.size());

        System.out.printf("%s : Sorting done for all queues. %n", taskName);
    }

    @Override
    public void run()
    {
        try
        {
            while (true) {
                sortQueueAndRecordLength();
                int sleepTime = generator.nextInt(5000, 10000);
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