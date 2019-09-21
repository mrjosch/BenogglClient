package de.jonas.benoggl.view.dialogs;

import de.jonas.benoggl.view.ViewController;
import javafx.stage.Stage;

public abstract class DialogViewController extends ViewController {

    private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
