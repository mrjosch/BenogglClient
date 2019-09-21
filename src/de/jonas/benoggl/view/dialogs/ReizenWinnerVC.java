package de.jonas.benoggl.view.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReizenWinnerVC extends DialogViewController {

    @FXML
    private Label name;

    @FXML
    private Label points;

    @Override
    public void init(Object... params) {
        String name = (String) params[0];
        int points = (int) params[1];

        this.name.setText(name);
        this.points.setText(points+"");
    }
}
