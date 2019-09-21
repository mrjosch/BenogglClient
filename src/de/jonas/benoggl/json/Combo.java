package de.jonas.benoggl.json;

import de.jonas.benoggl.commons.Cardname;
import de.jonas.benoggl.commons.Cardtype;
import de.jonas.benoggl.commons.Comboname;

import java.util.ArrayList;

public class Combo {

    private Comboname name;
    private Cardtype cardtype;
    private int points;

    private ArrayList<Card> cards;

    public Combo(Comboname name, Cardtype cardtype) {
        this.name = name;
        this.cardtype = cardtype;
        cards = initCards();
    }

    private ArrayList<Card> initCards() {
        ArrayList<Card> temp = new ArrayList<>();

        switch (name) {
            case BINOKEL:
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                points = 40;
                break;
            case DOPPELTER_BINOKEL:
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                points = 300;
                break;
            case VIER_ASS:
                temp.add(new Card(Cardtype.SHELL, Cardname.ASS));
                temp.add(new Card(Cardtype.HERZ, Cardname.ASS));
                temp.add(new Card(Cardtype.BLATT, Cardname.ASS));
                temp.add(new Card(Cardtype.EICHEL, Cardname.ASS));
                points = 100;
                break;
            case VIER_KÖNIGE:
                temp.add(new Card(Cardtype.SHELL, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.HERZ, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.BLATT, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.EICHEL, Cardname.KÖNIG));
                points = 80;
                break;
            case VIER_OBER:
                temp.add(new Card(Cardtype.SHELL, Cardname.OBER));
                temp.add(new Card(Cardtype.HERZ, Cardname.OBER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.OBER));
                points = 60;
                break;
            case VIER_UNTER:
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.HERZ, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.UNTER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.UNTER));
                points = 40;
                break;
            case ACHT_ASS:
                temp.add(new Card(Cardtype.SHELL, Cardname.ASS));
                temp.add(new Card(Cardtype.HERZ, Cardname.ASS));
                temp.add(new Card(Cardtype.BLATT, Cardname.ASS));
                temp.add(new Card(Cardtype.EICHEL, Cardname.ASS));
                temp.add(new Card(Cardtype.SHELL, Cardname.ASS));
                temp.add(new Card(Cardtype.HERZ, Cardname.ASS));
                temp.add(new Card(Cardtype.BLATT, Cardname.ASS));
                temp.add(new Card(Cardtype.EICHEL, Cardname.ASS));
                points = 1000;
                break;
            case ACHT_KÖNIGE:
                temp.add(new Card(Cardtype.SHELL, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.HERZ, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.BLATT, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.EICHEL, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.SHELL, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.HERZ, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.BLATT, Cardname.KÖNIG));
                temp.add(new Card(Cardtype.EICHEL, Cardname.KÖNIG));
                points = 1000;
                break;
            case ACHT_OBER:
                temp.add(new Card(Cardtype.SHELL, Cardname.OBER));
                temp.add(new Card(Cardtype.HERZ, Cardname.OBER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.OBER));
                temp.add(new Card(Cardtype.SHELL, Cardname.OBER));
                temp.add(new Card(Cardtype.HERZ, Cardname.OBER));
                temp.add(new Card(Cardtype.BLATT, Cardname.OBER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.OBER));
                points = 1000;
                break;
            case ACHT_UNTER:
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.HERZ, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.UNTER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.UNTER));
                temp.add(new Card(Cardtype.SHELL, Cardname.UNTER));
                temp.add(new Card(Cardtype.HERZ, Cardname.UNTER));
                temp.add(new Card(Cardtype.BLATT, Cardname.UNTER));
                temp.add(new Card(Cardtype.EICHEL, Cardname.UNTER));
                points = 1000;
                break;
            case FAMILIE:
                temp.add(new Card(cardtype, Cardname.UNTER));
                temp.add(new Card(cardtype, Cardname.OBER));
                temp.add(new Card(cardtype, Cardname.KÖNIG));
                temp.add(new Card(cardtype, Cardname.ZEHN));
                temp.add(new Card(cardtype, Cardname.ASS));
                points = 100;
                break;
            case DOPPELTE_FAMILIE:
                temp.add(new Card(cardtype, Cardname.UNTER));
                temp.add(new Card(cardtype, Cardname.OBER));
                temp.add(new Card(cardtype, Cardname.KÖNIG));
                temp.add(new Card(cardtype, Cardname.ZEHN));
                temp.add(new Card(cardtype, Cardname.ASS));
                temp.add(new Card(cardtype, Cardname.UNTER));
                temp.add(new Card(cardtype, Cardname.OBER));
                temp.add(new Card(cardtype, Cardname.KÖNIG));
                temp.add(new Card(cardtype, Cardname.ZEHN));
                temp.add(new Card(cardtype, Cardname.ASS));
                points = 1500;
                break;
            case PAAR:
                temp.add(new Card(cardtype, Cardname.OBER));
                temp.add(new Card(cardtype, Cardname.KÖNIG));
                points = 20;
                break;
        }
        return temp;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getPoints() {
        return points;
    }

    public Cardtype getCardtype() {
        return cardtype;
    }

    public Comboname getName() {
        return name;
    }
}

