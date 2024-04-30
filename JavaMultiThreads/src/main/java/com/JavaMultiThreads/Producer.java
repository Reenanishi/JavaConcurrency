package com.JavaMultiThreads;

import java.security.SecureRandom;

class Producer implements Runnable
{
    private final String taskName;
    private final Buffer buffer;
    private final int sleepTime;
    private static final SecureRandom generator = new SecureRandom();

    public Producer(String taskName, Buffer buffer, int sleepTime)
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
                System.out.printf("%s : Going to sleep for %d milliseconds.%n", taskName, sleepTime);
                Thread.sleep(sleepTime);
                Packet packet = new Packet();
                Integer randomInt = generator.nextInt(1000);
                packet.setPacket(randomInt.toString());
                System.out.printf("%s : Going to insert packet %s. Buffer size = %d %n", taskName, packet.toString(), buffer.getBufferSize());
                buffer.insertPkt(packet);
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
