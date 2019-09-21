package de.jonas.benoggl.view;

import de.jonas.benoggl.json.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CardView extends ImageView {

    private Card card;
    private int idd;

    public CardView(){
        updateImage();
    }

    public CardView(Card card) {
        this.card = card;
        updateImage();
    }

    public CardView(Card card, int idd) {
        this.idd = idd;
        this.card = card;
        updateImage();
    }

    public void setCard(Card card){
        this.card = card;
        updateImage();
    }

    public Card getCard() {
        return card;
    }

    public int getIdd() {
        return idd;
    }

    private void updateImage() {
        // size and some fxml settings first
        //  <CardView fx:id="enemy1_Card1" fitHeight="150.0" fitWidth="106.0" pickOnBounds="true" preserveRatio="true" />
        setFitHeight(150);
        setFitWidth(106);
        setPickOnBounds(true);
        setPreserveRatio(true);

        if(card == null) {
            this.setImage(loadImage("assets/card_back.jpg"));
        } else {
            String [] split;

            split = card.toString().split(" ");
            this.setImage(loadImage("assets/" + split[0] + "_" + split[1] + ".jpg"));
        }
    }

    private Image loadImage(String path) {
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Image(inputstream);
    }

    @Override
    public boolean equals(Object o) {
        return this.idd == ((CardView)o).idd;
    }
}
