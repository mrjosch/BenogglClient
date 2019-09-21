import de.jonas.benoggl.MainApp;
import de.jonas.benoggl.model.Game;
import de.jonas.benoggl.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Player2DialogVC {

    // Reference to the main application.
    private MainApp mainApp;

    private Stage dialogStage;

    @FXML
    private TextField name_Player1;
    @FXML
    private TextField name_Player2;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public Player2DialogVC() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void handleOk() {
        if(isInputValid()) {
            Game temp = new Game(new Player(name_Player1.getText()),new Player(name_Player2.getText()));
            mainApp.setGame(temp);
            showInGameView();
        }
    }

    public void handleCancel() {
        dialogStage.close();
    }

    private void showInGameView() {
        try {
            handleCancel();
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/res/Reizen2.fxml"));
            VBox inGameView = (VBox) loader.load();

            // Set inGameView into the center of root layout.
            mainApp.getRootLayout().setCenter(inGameView);

            // Give the controller access to the main app.
            InGameVC controller = loader.getController();
            controller.setMainApp(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isInputValid() {
        //TODO nur Zahlen und Buchstaben
        String errorMessage = "";

        if (name_Player1.getText() == null || name_Player1.getText().length() == 0 || name_Player2.getText() == null || name_Player2.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid name");
            alert.setHeaderText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
