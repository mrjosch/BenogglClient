package de.jonas.benoggl.view._2players.ingame;

import de.jonas.benoggl.commons.Cardname;
import de.jonas.benoggl.commons.Cardtype;
import de.jonas.benoggl.commons.ComboChecker;
import de.jonas.benoggl.commons.Comboname;
import de.jonas.benoggl.json.Card;
import de.jonas.benoggl.json.Combo;
import de.jonas.benoggl.json.in.MeldenSnapshot;
import de.jonas.benoggl.json.in.Next;
import de.jonas.benoggl.json.out.Action;
import de.jonas.benoggl.view.CardView;
import de.jonas.benoggl.view.ViewController;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Comparator;

public class Melden2VC extends ViewController {

    // Panes
    @FXML
    private HBox enemy_cards;

    @FXML
    private HBox my_cards;

    @FXML
    private FlowPane gemeldet_cards;

    @FXML
    private VBox meldenBorder;



    // Buttons
    @FXML
    private Button btn_sort;

    @FXML
    private Button btn_melden;


    // Data
    @FXML
    private Label my_Name;

    @FXML
    private Label enemy1_name;

    @FXML
    private Label reizenPoints;

    @FXML
    private Label meldenPoints;


    private String reizenWinner;


    private ArrayList<Combo> combos;

    private Cardtype trumpf;

    private boolean highlighted;

    @Override
    public void init(Object... params) {
        ArrayList<Card> my_Hand = (ArrayList<Card>) params[0];

        for (int i = 0; i < my_Hand.size(); i++) {
            my_cards.getChildren().add(new CardView(my_Hand.get(i), i));
        }

        enemy_cards.getChildren().addAll(new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null),new CardView(null));

        Next next = (Next) params[1];

        ArrayList<Card> dub = (ArrayList<Card>) params[2];

        reizenWinner = (String) params[3];

        if(next.name.equals(mainApp.name)) {
            highlighted = true;
            my_cards.getChildren().addAll(new CardView(dub.get(0),12),new CardView(dub.get(1),13), new CardView(dub.get(2),14),new CardView(dub.get(3),15));
        } else {
            enemy_cards.getChildren().addAll(new CardView(null),new CardView(null),new CardView(null),new CardView(null));
        }
        highlight();

        String myName = (String) params[4];
        String enemy1Name = (String) params[5];
        String points = (String) params[6];

        my_Name.setText(myName);
        enemy1_name.setText(enemy1Name);
        reizenPoints.setText(points);
        meldenPoints.setText("0");

        combos = new ArrayList<>();
        initView();
    }

    // MESSAGE HANDLING

    @Override
    public void onMeldenSnapshot(MeldenSnapshot meldenSnapshot) {

    }

    @Override
    public void onNext(Next next) {
        if(next.type.equals("melden")) {
            if(next.name.equals(mainApp.name)) {
                highlighted = true;
            } else {
                highlighted = false;
            }
            highlight();
        } else if(next.type.equals("stechen")) {
            mainApp.showStechen2Scene();
            Stechen2VC stechen2VC = (Stechen2VC) mainApp.windowViewController;
            stechen2VC.init(next, my_cards.getChildren(), enemy_cards.getChildren(), my_Name.getText(), enemy1_name.getText(), reizenPoints.getText());
        }
    }

    // UI

    private void initView() {
        for (int i = 0; i < my_cards.getChildren().size(); i++) {
            CardView cardView = (CardView) my_cards.getChildren().get(i);

            cardView.setOnDragOver(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            });

            cardView.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println("dragDetected start");
                    Dragboard db = cardView.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putImage(cardView.getImage());
                    db.setContent(content);
                    cardView.setVisible(false);
                    System.out.println("dragDetected end");
                }
            });

            cardView.setOnDragDropped(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    System.out.println("dragDrop start");
                    // swap the cards
                    CardView source = (CardView) dragEvent.getGestureSource();

                    if(my_cards.getChildren().contains(cardView)) {
                        if(my_cards.getChildren().contains(source)) {
                            // Hand Card -> Hand Card ==> swap
                            int index1 = my_cards.getChildren().indexOf(cardView);
                            int index2 = my_cards.getChildren().indexOf(source);

                            if(index1 > index2) {
                                my_cards.getChildren().remove(index1);
                                my_cards.getChildren().remove(index2);
                                my_cards.getChildren().add(index2, cardView);
                                my_cards.getChildren().add(index1, source);
                            } else {
                                my_cards.getChildren().remove(index2);
                                my_cards.getChildren().remove(index1);
                                my_cards.getChildren().add(index1, source);
                                my_cards.getChildren().add(index2, cardView);
                            }
                        } else if(gemeldet_cards.getChildren().contains(source)) {
                            // Melden Card -> Hand Card ==> swap
                            int iGem = gemeldet_cards.getChildren().indexOf(source);
                            int iHand = my_cards.getChildren().indexOf(cardView);
                            gemeldet_cards.getChildren().remove(source);
                            my_cards.getChildren().remove(cardView);
                            gemeldet_cards.getChildren().add(iGem, cardView);
                            my_cards.getChildren().add(iHand, source);
                        }
                    } else if(gemeldet_cards.getChildren().contains(cardView)) {
                        if(my_cards.getChildren().contains(source)) {
                            // Hand Card -> Melden Card ==> swap
                            int iGem = gemeldet_cards.getChildren().indexOf(cardView);
                            int iHand = my_cards.getChildren().indexOf(source);
                            gemeldet_cards.getChildren().remove(source);
                            my_cards.getChildren().remove(source);
                            gemeldet_cards.getChildren().add(iGem, source);
                            my_cards.getChildren().add(iHand, cardView);
                        } else if(gemeldet_cards.getChildren().contains(source)) {
                            // Melden Card -> Melden Card ==> swap
                            int index1 = gemeldet_cards.getChildren().indexOf(cardView);
                            int index2 = gemeldet_cards.getChildren().indexOf(source);
                            if(index1 > index2) {
                                gemeldet_cards.getChildren().remove(index1);
                                gemeldet_cards.getChildren().remove(index2);
                                gemeldet_cards.getChildren().add(index2, cardView);
                                gemeldet_cards.getChildren().add(index1, source);
                            } else {
                                gemeldet_cards.getChildren().remove(index2);
                                gemeldet_cards.getChildren().remove(index1);
                                gemeldet_cards.getChildren().add(index1, source);
                                gemeldet_cards.getChildren().add(index2, cardView);
                            }
                        }
                    }
                    refreshMeldenPoints();
                    System.out.println("dragDrop end");
                }
            });

            cardView.setOnDragDone(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    cardView.setVisible(true);

                    System.out.println("dragDone start");
                    System.out.println("Gemeldet");
                    for(Node node : gemeldet_cards.getChildren()){
                        System.out.println(((CardView) node).getCard().toString());
                    }
                    System.out.println("Hand");
                    for(Node node : my_cards.getChildren()){
                        System.out.println(((CardView) node).getCard().toString());
                    }
                    System.out.println("dragDone end");
                }
            });
        }

        my_cards.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
        });

        my_cards.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                CardView source = (CardView) dragEvent.getGestureSource();

                if(gemeldet_cards.getChildren().contains(source)) {
                    my_cards.getChildren().add(source);
                    gemeldet_cards.getChildren().remove(source);
                    refreshMeldenPoints();
                }
            }
        });

        meldenBorder.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if(gemeldet_cards.getChildren().size() < 12 && highlighted) {
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        meldenBorder.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if(gemeldet_cards.getChildren().size() < 12) {
                    CardView source = (CardView) dragEvent.getGestureSource();
                    if(my_cards.getChildren().contains(source)) {
                        gemeldet_cards.getChildren().add(source);
                        my_cards.getChildren().remove(source);
                        refreshMeldenPoints();
                    }
                }
            }
        });
    }

    private void refreshMeldenPoints() {
        combos.clear();

        ArrayList<Card> gemeldeteKarten = new ArrayList<>();
        for (Node node : gemeldet_cards.getChildren()) {
            CardView cardView = (CardView) node;
            gemeldeteKarten.add(cardView.getCard());
        }

        if(ComboChecker.checkAchtAss(gemeldeteKarten)) {
            combos.add(new Combo(Comboname.ACHT_ASS,null));
        } else {
            if(ComboChecker.checkVierAss(gemeldeteKarten)) {
                combos.add(new Combo(Comboname.VIER_ASS,null));
            }
        }

        if(ComboChecker.checkAchtKoenige(gemeldeteKarten)) {
            combos.add(new Combo(Comboname.ACHT_KÖNIGE,null));
        } else {
            if(ComboChecker.checkVierKoenige(gemeldeteKarten)) {
                combos.add(new Combo(Comboname.VIER_KÖNIGE,null));
            }
        }

        if(ComboChecker.checkAchtOber(gemeldeteKarten)) {
            combos.add(new Combo(Comboname.ACHT_OBER,null));
        } else {
            if(ComboChecker.checkVierOber(gemeldeteKarten)) {
                combos.add(new Combo(Comboname.VIER_OBER,null));
            }
        }

        if(ComboChecker.checkAchtUnter(gemeldeteKarten)) {
            combos.add(new Combo(Comboname.ACHT_UNTER,null));
        } else {
            if(ComboChecker.checkVierUnter(gemeldeteKarten)) {
                combos.add(new Combo(Comboname.VIER_UNTER,null));
            }
        }

        if(ComboChecker.checkDoppelterBinokel(gemeldeteKarten)) {
            combos.add(new Combo(Comboname.DOPPELTER_BINOKEL,null));
        } else {
            if(ComboChecker.checkBinokel(gemeldeteKarten)) {
                combos.add(new Combo(Comboname.BINOKEL,null));
            }
        }

        if(ComboChecker.checkDoppelteFamilie(gemeldeteKarten) != null) {
            combos.add(new Combo(Comboname.DOPPELTE_FAMILIE,ComboChecker.checkDoppelteFamilie(gemeldeteKarten)));
        } else {
            for (int i = 0; i < ComboChecker.checkFamilie(gemeldeteKarten).size() ; i++) {
                combos.add(new Combo(Comboname.FAMILIE, ComboChecker.checkFamilie(gemeldeteKarten).get(i)));
            }
        }

        for (int i = 0; i < ComboChecker.checkPaar(gemeldeteKarten).size() ; i++) {
            combos.add(new Combo(Comboname.PAAR, ComboChecker.checkPaar(gemeldeteKarten).get(i)));
        }

        int points = 0;


        ArrayList<Cardtype> famColers = new ArrayList<>();
        for(Combo combo : combos) {
            if(combo.getName().equals(Comboname.FAMILIE)) {
                famColers.add(combo.getCardtype());
            }
        }

        for(Cardtype cardtype : famColers) {
            for(Combo combo : combos) {
                if(combo.getCardtype().equals(cardtype) && combo.getName().equals(Comboname.PAAR)) {
                    combos.remove(combo);
                    break;
                }
            }
        }

        for(Combo combo : combos) {
            System.out.println(combo.getName().toString());
            if(combo.getCardtype().equals(trumpf)) {
                points+= combo.getPoints();
            }
            points+= combo.getPoints();
        }

        meldenPoints.setText(points+"");
    }

    private void highlight() {
        if(highlighted) {
            btn_melden.setVisible(true);
            meldenBorder.setStyle(" -fx-border-color:red; -fx-border-radius: 18 18 18 18; -fx-border-width: 3; -fx-border-style: solid;");
        } else {
            btn_melden.setVisible(false);
            meldenBorder.setStyle(" -fx-border-color:black; -fx-border-radius: 18 18 18 18; -fx-border-width: 1; -fx-border-style: solid;");
        }
    }


    // Button onClick
    public void sortHand() {
        FXCollections.sort(my_cards.getChildren(), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                CardView c1 = (CardView) o1;
                CardView c2 = (CardView) o2;
                return c1.getCard().compareTo(c2.getCard());
            }
        });
    }

    public void melden() {
        mainApp.sendPacket(new Action(combos));
    }

}
