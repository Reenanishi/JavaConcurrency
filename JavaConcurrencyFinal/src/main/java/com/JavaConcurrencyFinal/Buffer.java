package com.JavaConcurrencyFinal;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Packet> queue = new LinkedList<>();

    // Synchronized access of queue
    public synchronized void insertPkt(Packet packet) {
        // Insert packet to queue
        queue.add(packet);
    }

    // Synchronized access of queue
    public synchronized Packet removePkt() {
        // Check packet  is not empty
        if (queue.isEmpty()) {
            return null;
        }

        // Remove packet from queue
        return queue.poll();
    }

    // Synchronized access of queue
    public synchronized int getBufferSize() {

        // Get queue  size
        return queue.size();
    }
}
