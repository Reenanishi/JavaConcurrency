package com.JavaMultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{


    public static void test1()
    {

        /*
        Have the producer sleep less time than the consumer (say by a factor of 10),
        so it produces more packets than the consumer consumes in a period of time.
         */


        final Buffer buffer = new Buffer();

        Runnable producer1 = new Producer("Producer1", buffer, 1000);
        Runnable consumer1 = new Consumer("Consumer1", buffer, 10000);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(consumer1);

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");

    }


    public static void test2()
    {

        /*
        Start a second consumer and any more such that the consumers
         balance out the producers packets. How many consumers
         did you find balanced the production.
         */


        final Buffer buffer = new Buffer();

        Runnable producer1 = new Producer("Producer1", buffer, 1000);
        Runnable consumer1 = new Consumer("Consumer1", buffer, 10000);
        Runnable consumer2 = new Consumer("Consumer2", buffer, 10000);
        Runnable consumer3 = new Consumer("Consumer3", buffer, 10000);
        Runnable consumer4 = new Consumer("Consumer4", buffer, 10000);
        Runnable consumer5 = new Consumer("Consumer5", buffer, 10000);
        Runnable consumer6 = new Consumer("Consumer6", buffer, 10000);
        Runnable consumer7 = new Consumer("Consumer7", buffer, 10000);
        Runnable consumer8 = new Consumer("Consumer8", buffer, 10000);
        Runnable consumer9 = new Consumer("Consumer9", buffer, 10000);
        Runnable consumer10 = new Consumer("Consumer10", buffer, 10000);
        Runnable consumer11 = new Consumer("Consumer11", buffer, 10000);


        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        executorService.execute(consumer4);
        executorService.execute(consumer5);
        executorService.execute(consumer6);
        executorService.execute(consumer7);
        executorService.execute(consumer8);
        executorService.execute(consumer9);
        executorService.execute(consumer10);
        executorService.execute(consumer11);

        // 10 consumers out balance 1 producer


        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");

    }


    public static void test3()
    {

        /*
        Now have the producer sleep more time than the consumers before
        going to consume from the Buffer. How often does
         a consumer block waiting for packets – what is the time comparison
         between the producers sleep time and consumers blocking time.
         */


        final Buffer buffer = new Buffer();

        Runnable producer1 = new Producer("Producer1", buffer, 10000);
        Runnable consumer1 = new Consumer("Consumer1", buffer, 1000);



        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(consumer1);


        try {
            executorService.awaitTermination(30, TimeUnit.MINUTES);
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");

    }


    public static void test4()
    {

        /*
            Optional Extra Credit: Use any mechanism to synchronize the producer thread pushing packets
             into the Buffer and the consumer thread removing them such that the Buffer size always
             remains between 50-70 packets. Note that all packets must be processed.
             Show how your objective is met by running the Producer and Consumer object for a long period
             of time an showing the Buffer size never drops below 50 and never exceeds 70.
         */


        final Buffer buffer = new Buffer();

        Runnable producer1 = new Producer("Producer1", buffer, 1000);
        Runnable consumer1 = new ConsumerExtraCredit("Consumer1", buffer, 10000);
        Runnable consumer2 = new ConsumerExtraCredit("Consumer2", buffer, 10000);
        Runnable consumer3 = new ConsumerExtraCredit("Consumer3", buffer, 10000);
        Runnable consumer4 = new ConsumerExtraCredit("Consumer4", buffer, 10000);
        Runnable consumer5 = new ConsumerExtraCredit("Consumer5", buffer, 10000);
        Runnable consumer6 = new ConsumerExtraCredit("Consumer6", buffer, 10000);
        Runnable consumer7 = new ConsumerExtraCredit("Consumer7", buffer, 10000);
        Runnable consumer8 = new ConsumerExtraCredit("Consumer8", buffer, 10000);
        Runnable consumer9 = new ConsumerExtraCredit("Consumer9", buffer, 10000);
        Runnable consumer10 = new ConsumerExtraCredit("Consumer10", buffer, 10000);


        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        executorService.execute(consumer4);
        executorService.execute(consumer5);
        executorService.execute(consumer6);
        executorService.execute(consumer7);
        executorService.execute(consumer8);
        executorService.execute(consumer9);
        executorService.execute(consumer10);


        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Tasks started, main ends.%n%n");

    }


    public static void main(String[] args)
    {

      test1();
//      test2();
//        test3();
//        test4();
    }
}