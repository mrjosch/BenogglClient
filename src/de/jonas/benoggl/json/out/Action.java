package de.jonas.benoggl.json.out;

import de.jonas.benoggl.json.Card;
import de.jonas.benoggl.json.Combo;

import java.util.ArrayList;

public class Action implements PacketOut {

    public String type;

    public Boolean overbid;
    public ArrayList<Combo> cardCombos;
    public Card card;

    public Action(Boolean overbid) {
        this.type = "reizen";
        this.overbid = overbid;
        cardCombos = null;
        card = null;
    }

    public Action(ArrayList<Combo> cardCombos) {
        this.type = "melden";
        this.cardCombos = cardCombos;
        overbid = null;
        card = null;
    }

    public Action(String type, Card card) {
        this.type = "stechen";
        this.card = card;
        overbid = null;
        cardCombos = null;
    }
}
