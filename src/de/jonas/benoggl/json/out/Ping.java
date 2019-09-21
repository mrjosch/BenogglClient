package de.jonas.benoggl.json.out;

public class Ping implements PacketOut{

    public String ping;

    public Ping(String ping) {
        this.ping = ping;
    }
}
