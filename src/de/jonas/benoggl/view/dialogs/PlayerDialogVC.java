package de.jonas.benoggl.view.dialogs;

import de.jonas.benoggl.json.in.JoinResponse;
import de.jonas.benoggl.json.in.LobbySnapshot;
import de.jonas.benoggl.json.out.JoinRequest;
import de.jonas.benoggl.view._2players.Lobby2VC;
import de.jonas.benoggl.view._3players.Lobby3VC;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PlayerDialogVC extends DialogViewController {

    private JoinResponse joinResponse;

    @FXML
    private TextField name;

    @Override
    public void init(Object... params) {
    }

    // MESSAGE HANDLING

    @Override
    public void onJoinResponse(JoinResponse joinResponse) {
        this.joinResponse = joinResponse;
        if(!joinResponse.successful) {
            //TODO name already in use oder schon voll unterscheiden
            showErrorDialog("Couldn't join Game");
        }
    }

    @Override
    public void onLobbySnapshot(LobbySnapshot lobbySnapshot) {
        if(joinResponse.successful) {
            switch (lobbySnapshot.lobbyName) {
                case "LOBBY2":
                    mainApp.showLobby2Scene();
                    ((Lobby2VC) mainApp.windowViewController).updateView(lobbySnapshot);
                    break;
                case "LOBBY3":
                    mainApp.showLobby3Scene();
                    ((Lobby3VC) mainApp.windowViewController).updateView(lobbySnapshot);
                    break;
                case "LOBBY4":
                    mainApp.showLobby4Scene();
                    ((Lobby3VC) mainApp.windowViewController).updateView(lobbySnapshot);
                    break;
            }
        }
    }



    private void sendJoinRequest() {
        mainApp.name = name.getText();
        mainApp.sendPacket(new JoinRequest(name.getText()));
    }

    private boolean isInputValid() {
        String errorMessage = "";

        //TODO regex
        if (name.getText() == null || name.getText().length() == 0 || name.getText().contains("_")) {
            errorMessage = "No valid name!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            showErrorDialog(errorMessage);
            return false;
        }
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainApp.dialogStage);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }


    // Button onClick

    public void handleOk() {
        if(isInputValid()){
            if(mainApp.connected) {
                sendJoinRequest();
            } else {
                showErrorDialog("Connection failed");
            }
        } else {
            showErrorDialog("Invalid name");
        }
    }

    public void handleCancel() {
        mainApp.dialogStage.close();
        mainApp.disconnect();
    }


    // GETTER AND SETTER

}
