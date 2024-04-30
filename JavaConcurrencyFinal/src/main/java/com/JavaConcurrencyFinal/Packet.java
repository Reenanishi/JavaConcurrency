package com.JavaConcurrencyFinal;

public class Packet {
    private String  packet = "";

    public void setPacket(String  packet) {
        this.packet = packet;
     }

    public String toString() {
        return "[ Packet = " + this.packet + " ] ";
    }
}
