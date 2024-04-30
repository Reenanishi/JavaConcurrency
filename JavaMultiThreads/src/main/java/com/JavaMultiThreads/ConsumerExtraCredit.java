package com.JavaMultiThreads;

import java.security.SecureRandom;


class ConsumerExtraCredit implements Runnable
{
    private final String taskName;
    private final Buffer buffer;
    private final int sleepTime;
    private static final SecureRandom generator = new SecureRandom();


    public ConsumerExtraCredit(String taskName, Buffer buffer, int sleepTime)
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

                if ( buffer.getBufferSize() > 60) {
                    Packet packet = buffer.removePkt();
                    if (packet != null) {
                        System.out.printf("%s : Removed packet %s. Buffer size = %d %n", taskName, packet.toString(), buffer.getBufferSize());
                    } else {
                        System.out.printf("%s : Buffer is empty %s. Buffer size = 0 %n", taskName);
                    }
                }
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
