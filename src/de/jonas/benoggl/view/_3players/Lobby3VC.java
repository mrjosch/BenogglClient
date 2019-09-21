package de.jonas.benoggl.view._3players;

import de.jonas.benoggl.json.in.GameStart;
import de.jonas.benoggl.json.in.LobbySnapshot;
import de.jonas.benoggl.view.ViewController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class Lobby3VC extends ViewController {

    private LobbySnapshot lobbySnapshot;
    private GameStart gameStart;

    @FXML
    private Label player1_name;

    @FXML
    private Label player2_name;

    @FXML
    private Label player3_name;

    @Override
    public void init(Object... params) {

    }

    public void handle(Object o) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(o instanceof LobbySnapshot) {
                    LobbySnapshot snapshot = (LobbySnapshot)o;
                    updateView(snapshot);
                }
            }
        });
    }


    public void updateView(LobbySnapshot snapshot) {
        player1_name.setTextFill(Paint.valueOf("black"));
        player2_name.setTextFill(Paint.valueOf("black"));
        player3_name.setTextFill(Paint.valueOf("black"));
        player1_name.setText(snapshot.player1Name);
        player2_name.setText(snapshot.player2Name);
        player3_name.setText(snapshot.player3Name);

        if(mainApp.name.equals(snapshot.player1Name)) {
            player1_name.setTextFill(Paint.valueOf("green"));
        } else if(mainApp.name.equals(snapshot.player2Name)) {
            player2_name.setTextFill(Paint.valueOf("green"));
        } else if(mainApp.name.equals(snapshot.player3Name)) {
            player3_name.setTextFill(Paint.valueOf("green"));
        }
    }

    private void showInGameView() {
        mainApp.showReizen3Scene();
    }


    // GETTER AND SETTER

    public void setLobbySnapshot(LobbySnapshot lobbySnapshot) {
        this.lobbySnapshot = lobbySnapshot;
    }

    public GameStart getGameStart() {
        return gameStart;
    }

    public void setPlayer1_name(String name) {
        player1_name.setText(name);
    }

    public void setPlayer2_name(String name) {
        player2_name.setText(name);
    }

    public void setPlayer3_name(String name) {
        player3_name.setText(name);
    }

}
