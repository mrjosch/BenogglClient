package de.jonas.benoggl.view.mainmenu;

import de.jonas.benoggl.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MainMenuVC extends ViewController {

    @FXML
    private Button btn_2players;

    @FXML
    private Button btn_3players;

    @FXML
    private Button btn_4players;

    @Override
    public void init(Object... params) {
    }


    public void showPlayer2Dialog() {
        if(mainApp.connect("localhost", 8869)) {
            showPlayerDialog();
        } else {
            showErrorDialog("Server not reachable");
        }
    }

    public void showPlayer3Dialog() {
        if(mainApp.connect("localhost", 8870)) {
            showPlayerDialog();
        } else {
            showErrorDialog("Server not reachable");
        }
    }

    public void showPlayer4Dialog() {
        if(mainApp.connect("localhost", 8871)) {
            showPlayerDialog();
        } else {
            showErrorDialog("Server not reachable");
        }
    }

    private void showPlayerDialog() {
        mainApp.showDialog("view/dialogs/PlayerDialog.fxml","Choose Name", true);
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainApp.window);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

}