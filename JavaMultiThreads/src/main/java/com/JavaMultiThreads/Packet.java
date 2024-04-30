package com.JavaMultiThreads;

public class Packet {
     private String  packet = "";

     public void setPacket(String  packet) {
         this.packet = packet;
     }

    public String getPacket() {
        return this.packet;
    }

    public String toString() {
        return "[ Packet = " + this.packet + " ] ";
    }
}
