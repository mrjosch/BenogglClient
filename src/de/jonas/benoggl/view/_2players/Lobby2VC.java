package de.jonas.benoggl.view._2players;

import de.jonas.benoggl.json.in.GameStart;
import de.jonas.benoggl.json.in.LobbySnapshot;
import de.jonas.benoggl.view.ViewController;
import de.jonas.benoggl.view._2players.ingame.Reizen2VC;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class Lobby2VC extends ViewController {

    @FXML
    private Label player1_name;

    @FXML
    private Label player2_name;

    @FXML
    private Label countDown;

    @Override
    public void init(Object... params) {
    }

    // MESSAGE HANDLING

    @Override
    public void onLobbySnapshot(LobbySnapshot lobbySnapshot) {
        updateView(lobbySnapshot);
    }

    @Override
    public void onGameStart(GameStart gameStart) {
        displayCountdown(gameStart.countdown);
        mainApp.showReizen2Scene();
        Reizen2VC reizen2VC = (Reizen2VC) mainApp.windowViewController;
        reizen2VC.init(gameStart);
    }



    public void updateView(LobbySnapshot snapshot) {
        player1_name.setTextFill(Paint.valueOf("black"));
        player2_name.setTextFill(Paint.valueOf("black"));
        player1_name.setText(snapshot.player1Name);
        player2_name.setText(snapshot.player2Name);

        if(mainApp.name.equals(snapshot.player1Name)) {
            player1_name.setTextFill(Paint.valueOf("green"));
        } else if(mainApp.name.equals(snapshot.player2Name)) {
            player2_name.setTextFill(Paint.valueOf("green"));
        }
    }

    private void displayCountdown(int countdown) {
        // TODO
    }

    // GETTER AND SETTER

}
