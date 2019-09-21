package de.jonas.benoggl.json.in;

import de.jonas.benoggl.json.Card;

import java.util.ArrayList;

public class ReizenFinish implements PacketIn {

    public String nameWinner;
    public int pointsToMake;
    public ArrayList<Card> dub;

    public ReizenFinish(String nameWinner, int pointsToMake, ArrayList<Card> dub) {
        this.nameWinner = nameWinner;
        this.pointsToMake = pointsToMake;
        this.dub = dub;
    }
}
