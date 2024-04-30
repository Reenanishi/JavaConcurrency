package com.JavaConcurrencyFinal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{

    public static void main(String[] args)
    {
        final Buffer buffer = new Buffer();

        // Create producer and consumer
        Runnable producer1 = new Producer("Producer1", buffer);
        Runnable consumer1 = new Consumer("Consumer1", buffer);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(consumer1);

        try {
            // Await for 5 mins
            executorService.awaitTermination(5, TimeUnit.MINUTES);
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");
    }
}