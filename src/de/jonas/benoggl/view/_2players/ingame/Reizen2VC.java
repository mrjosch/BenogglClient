package de.jonas.benoggl.view._2players.ingame;

import de.jonas.benoggl.json.Card;
import de.jonas.benoggl.json.in.*;
import de.jonas.benoggl.json.out.Action;
import de.jonas.benoggl.view.CardView;
import de.jonas.benoggl.view._2players.Lobby2VC;
import de.jonas.benoggl.view.dialogs.ReizenWinnerVC;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;

public class Reizen2VC extends InGame2VC {

    @FXML
    private CardView dub_Card1;

    @FXML
    private CardView dub_Card2;

    @FXML
    private CardView dub_Card3;

    @FXML
    private CardView dub_Card4;

    @FXML
    private Button btn_sort;

    @FXML
    private Button btn_overbid;

    @FXML
    private Button btn_weg;

    @FXML
    private Label reizenPoints;

    private ArrayList<Card> dub;

    @Override
    public void init(Object... params) {
        GameStart gameStart = (GameStart) params[0];
        my_Hand = gameStart.cards;
        my_Name.setText(mainApp.name);
        if(gameStart.namePlayer1.equals(mainApp.name)) {
            enemy1_name.setText(gameStart.namePlayer2);
        } else{
            enemy1_name.setText(gameStart.namePlayer1);
        }
        onNext(gameStart.firstNext);
        btn_weg.setVisible(false);
        displayReizenView();
    }

    // MESSAGE HANDLING

    public void onLobbySnapshot(LobbySnapshot lobbySnapshot) {
        goBackToLobby(lobbySnapshot);
    }

    public void onNext(Next next) {
        if(next.type.equals("reizen")){
            if(next.name.equals(mainApp.name)){
                highlightMeReizen();
            } else {
                highlightEnemy1Reizen();
            }
        } else if(next.type.equals("melden")) {
            mainApp.showMelden2Scene();
            Melden2VC melden2VC = (Melden2VC) mainApp.windowViewController;
            melden2VC.init(my_Hand,next,dub, next.name, my_Name.getText(), enemy1_name.getText(), reizenPoints.getText());
        }
    }

    public void onReizenSnapshot(ReizenSnapshot reizenSnapshot){
        reizenPoints.setText(reizenSnapshot.points+"");
        btn_overbid.setText(reizenSnapshot.points+10+"");
    }

    public void onReizenFinish(ReizenFinish reizenFinish) {
        dub = reizenFinish.dub;
        displayReizenFinish(reizenFinish.nameWinner, reizenFinish.pointsToMake);
    }


    // UI

    public void displayReizenView() {
        ArrayList<CardView> cardViews = new ArrayList<>();
        cardViews.add(my_Card1);
        cardViews.add(my_Card2);
        cardViews.add(my_Card3);
        cardViews.add(my_Card4);
        cardViews.add(my_Card5);
        cardViews.add(my_Card6);
        cardViews.add(my_Card7);
        cardViews.add(my_Card8);
        cardViews.add(my_Card9);
        cardViews.add(my_Card10);
        cardViews.add(my_Card11);
        cardViews.add(my_Card12);

        for (int i = 0; i < cardViews.size(); i++) {
            CardView cardView = cardViews.get(i);
            cardView.setCard(my_Hand.get(i));
        }
    }

    private void goBackToLobby(LobbySnapshot lobbySnapshot){
        if(lobbySnapshot.lobbyName.equals("LOBBY2")) {
            mainApp.showLobby2Scene();
            ((Lobby2VC) mainApp.windowViewController).updateView(lobbySnapshot);
        }
    }

    public void highlightMeReizen() {
        btn_overbid.setVisible(true);
        btn_weg.setVisible(true);
    }

    public void highlightEnemy1Reizen() {
        btn_overbid.setVisible(false);
        btn_weg.setVisible(false);
    }

    public void displayReizenFinish(String name,int points) {
        mainApp.showDialog("view/dialogs/ReizenWinner.fxml",name + " hot's Spiel", false);
        ReizenWinnerVC reizenWinnerVC = (ReizenWinnerVC) mainApp.dialogViewController;
        /*reizenWinnerVC.setName(name);
        reizenWinnerVC.setPoints(points);*/
        reizenWinnerVC.init(name, points);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mainApp.dialogStage.close();
                    displayDub(dub);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void displayDub(ArrayList<Card>dub){
        dub_Card1.setCard(dub.get(0));
        dub_Card2.setCard(dub.get(1));
        dub_Card3.setCard(dub.get(2));
        dub_Card4.setCard(dub.get(3));
    }


    // Button onClick
    public void sortHand() {
        Collections.sort(my_Hand);
        displayReizenView();
    }

    public void handleOverBid(){
        mainApp.sendPacket(new Action(true));
        btn_overbid.setVisible(false);
        btn_weg.setVisible(false);
    }

    public void handleWeg(){
        mainApp.sendPacket(new Action(false));
        btn_overbid.setVisible(false);
        btn_weg.setVisible(false);
    }

    // GETTER AND SETTER

}