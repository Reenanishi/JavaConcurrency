package com.JavaConcurrencyFinal;

import java.security.SecureRandom;

class Producer implements Runnable
{
    private final String taskName;
    private final Buffer buffer;
    private static final SecureRandom generator = new SecureRandom();

    public Producer(String taskName, Buffer buffer)
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

                int sleepTime = generator.nextInt(1000 , 10000);
                System.out.printf("%s : Going to sleep for %d milliseconds.%n", taskName, sleepTime);
                // Sleep thread
                Thread.sleep(sleepTime);

                // Create packet
                Packet packet = new Packet();
                // Producer produces from 1 to 10
                Integer randomInt = generator.nextInt(1 , 10 );
                packet.setPacket(randomInt.toString());
                System.out.printf("%s : Going to insert packet %s. Buffer size = %d %n", taskName, packet.toString(), buffer.getBufferSize());

                // Insert packet to buffer
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
