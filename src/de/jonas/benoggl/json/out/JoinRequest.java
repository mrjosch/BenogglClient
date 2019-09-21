package de.jonas.benoggl.json.out;

public class JoinRequest implements PacketOut {

    public String name;

    public JoinRequest(String name) {
        this.name = name;
    }
}
