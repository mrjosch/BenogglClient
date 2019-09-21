package de.jonas.benoggl.json.in;

public class Next implements PacketIn {

    public String name;
    public String type;

    public Next(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
