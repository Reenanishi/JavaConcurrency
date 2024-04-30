package com.JavaMultiThreads;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Packet> queue = new LinkedList<>();

    public synchronized void insertPkt(Packet packet) {
        queue.add(packet);
    }

    public synchronized Packet removePkt() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public synchronized int getBufferSize() {
        return queue.size();
    }
}
