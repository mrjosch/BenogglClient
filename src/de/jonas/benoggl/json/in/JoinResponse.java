package de.jonas.benoggl.json.in;

public class JoinResponse implements PacketIn {

    public boolean successful;

    public JoinResponse(boolean successful) {
        this.successful = successful;
    }
}
