package com.JavaMultiThreads;

import java.security.SecureRandom;
import java.util.Vector;


class Consumer implements Runnable
{
    private final String taskName;
    private final Buffer buffer;
    private final int sleepTime;
    private static final SecureRandom generator = new SecureRandom();
    private boolean checkGreaterThan70 = false;
    private int  consumerWaitingTime = 0;



    public Consumer(String taskName, Buffer buffer, int sleepTime)
    {
        this.taskName = taskName;
        this.buffer = buffer;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run()
    {
        try
        {


            while (true) {

                if (checkGreaterThan70 || buffer.getBufferSize() > 70) {
                    Packet packet = buffer.removePkt();
                    if (packet != null) {
                        System.out.printf("%s : Removed packet %s. Buffer size = %d . consumerWaitingTime = %d %n", taskName, packet.toString(), buffer.getBufferSize(), consumerWaitingTime);
                        consumerWaitingTime = 0;
                    } else {
                        System.out.printf("%s : Buffer is empty. Buffer size = 0 %n", taskName);
                    }
                    checkGreaterThan70 = true;
                }
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
