package de.jonas.benoggl.view.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TrumpfDialogVC extends DialogViewController {

    @FXML
    ImageView herzDisplayer;

    @FXML
    ImageView shellDisplayer;

    @FXML
    ImageView eichelDisplayer;

    @FXML
    ImageView blattDisplayer;





    @FXML
    RadioButton radio_herz;

    @FXML
    RadioButton radio_shell;

    @FXML
    RadioButton radio_blatt;

    @FXML
    RadioButton radio_eichel;

    @FXML
    Button btn_melden;

    @Override
    public void init(Object... params) {
        herzDisplayer.setImage(loadImage("assets/herz_ass.jpg"));
        eichelDisplayer.setImage(loadImage("assets/eichel_ass.jpg"));
        blattDisplayer.setImage(loadImage("assets/blatt_ass.jpg"));
        shellDisplayer.setImage(loadImage("assets/shell_ass.jpg"));
    }


    public void onMelden(){
        if(radio_blatt.isSelected()) {
            System.out.println("BLATT");
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
}
