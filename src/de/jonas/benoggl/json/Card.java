package de.jonas.benoggl.json;

import de.jonas.benoggl.commons.Cardname;
import de.jonas.benoggl.commons.Cardtype;

public class Card implements Comparable{

    private Cardtype type;
    private Cardname name;

    public Card(Cardtype type, Cardname name) {
        this.type = type;
        this.name = name;
    }

    public Cardtype getType() {
        return type;
    }

    public Cardname getName() {
        return name;
    }


    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        if(this.type.equals(card.type)) {
            if(this.name.equals(card.name)){
                return 0;
            } else {
                if(this.name.equals(Cardname.ASS)){
                    return -1;
                } else if(this.name.equals(Cardname.ZEHN)) {
                    if(card.name.equals(Cardname.ASS)) {
                        return 1;
                    }
                    return -1;
                } else if(this.name.equals(Cardname.KÖNIG)) {
                    if(card.name.equals(Cardname.ASS) || card.name.equals(Cardname.ZEHN)) {
                        return 1;
                    }
                    return -1;
                } else if(this.name.equals(Cardname.OBER)) {
                    if(card.name.equals(Cardname.UNTER) || card.name.equals(Cardname.SIEBEN)) {
                        return -1;
                    }
                    return 1;
                } else if(this.name.equals(Cardname.UNTER)) {
                    if(card.name.equals(Cardname.SIEBEN)) {
                        return -1;
                    }
                    return 1;
                }
                return 1;
            }
        } else {
            if(this.type.equals(Cardtype.SHELL)) {
                return -1;
            } else if(this.type.equals(Cardtype.HERZ)) {
                if(card.type.equals(Cardtype.SHELL)) {
                    return 1;
                }
                return -1;
            } else if(this.type.equals(Cardtype.BLATT)) {
                if(card.type.equals(Cardtype.EICHEL)) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }


    @Override
    public String toString() {
        return type.toString() + " " + name.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Card card = (Card) obj;
        return this.type.equals(card.type) && this.name.equals(card.name);
    }
}
