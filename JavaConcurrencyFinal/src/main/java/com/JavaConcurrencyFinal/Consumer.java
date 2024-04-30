package com.JavaConcurrencyFinal;

import java.security.SecureRandom;

class Consumer implements Runnable
{
    private final String taskName;
    private final Buffer buffer;
    private int  consumerWaitingTime = 0;
    private static final SecureRandom generator = new SecureRandom();



    public Consumer(String taskName, Buffer buffer)
    {
        this.taskName = taskName;
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        try
        {

            while (true) {

                // Get packet
                Packet packet = buffer.removePkt();

                // Check if packet is not empty and print accordingly
                if (packet != null) {
                    System.out.printf("%s : Removed packet %s. Buffer size = %d . ConsumerWaitingTime = %d milliseconds %n", taskName, packet.toString(), buffer.getBufferSize(), consumerWaitingTime);
                    consumerWaitingTime = 0;
                } else {
                    System.out.printf("%s : Buffer is empty. Buffer size = 0 %n", taskName);
                }

                int sleepTime = generator.nextInt(1000 , 10000);


                // Increase waiting  time
                consumerWaitingTime += sleepTime;
                System.out.printf("%s : Going to sleep for %d milliseconds.%n", taskName, sleepTime);
                Thread.sleep(sleepTime);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.printf("%s : Exit %n", taskName);
    }
}
