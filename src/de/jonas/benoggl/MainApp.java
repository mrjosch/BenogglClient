package de.jonas.benoggl;

import de.jonas.benoggl.json.Container;
import de.jonas.benoggl.json.JSONConverter;
import de.jonas.benoggl.json.out.PacketOut;
import de.jonas.benoggl.networking.NetworkClient;
import de.jonas.benoggl.view.ViewController;
import de.jonas.benoggl.view.mainmenu.MainMenuVC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Timestamp;


public class MainApp extends Application {

    // --module-path C:\Users\Jonas\Downloads\javafx-sdk-11.0.2\lib --add-modules=javafx.controls,javafx.fxml
    public static void main(String[] args) {
        launch(args);
    }

    public volatile boolean connected;

    public String name;

    public Stage window;
    public Stage dialogStage;
    public ViewController windowViewController;
    public ViewController dialogViewController;

    public Scene mainMenu, lobby, reizen, melden, stechen, gameResult;

    public NetworkClient networkClient;


    public MainApp() {
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        showMainMenuScene();
    }

    @Override
    public void stop(){
        connected = false;
    }



    // SCENES

    public void showMainMenuScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/mainmenu/MainMenu.fxml"));
            AnchorPane pane = loader.load();
            windowViewController = loader.getController();

            MainMenuVC ctrl =  (MainMenuVC) windowViewController;
            ctrl.mainApp = this;

            mainMenu = new Scene(pane);
            window.setScene(mainMenu);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLobby2Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_2players/Lobby2.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier

            window.setTitle(name);
            lobby = new Scene(pane);
            window.setScene(lobby);

            dialogStage.close();

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLobby3Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_3players/Lobby3.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier

            lobby = new Scene(pane);
            window.setScene(lobby);

            dialogStage.close();

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLobby4Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_3players/Lobby4.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier

            lobby = new Scene(pane);
            window.setScene(lobby);

            dialogStage.close();

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReizen2Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_2players/ingame/Reizen2.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            reizen = new Scene(pane);
            window.setScene(reizen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReizen3Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_3players/ingame/Reizen3.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            reizen = new Scene(pane);
            window.setScene(reizen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReizen4Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_4players/ingame/Reizen4.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            reizen = new Scene(pane);
            window.setScene(reizen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMelden2Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_2players/ingame/Melden2.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            melden = new Scene(pane);
            window.setScene(melden);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMelden3Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_3players/ingame/Melden3.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            melden = new Scene(pane);
            window.setScene(melden);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMelden4Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_4players/ingame/Melden4.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            melden = new Scene(pane);
            window.setScene(melden);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStechen2Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_2players/ingame/Stechen2.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            stechen = new Scene(pane);
            window.setScene(stechen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStechen3Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/_3players/ingame/Stechen3.fxml"));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            stechen = new Scene(pane);
            window.setScene(stechen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStechen4Scene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("\"view/_4players/ingame/Stechen4.fxml\""));
            VBox pane = loader.load();

            // TODO passt das ?
            windowViewController = loader.getController();
            windowViewController.mainApp = this;
            if(networkClient != null) {
                networkClient.setNetworkListener(windowViewController);
            }
            // TODO bis hier
            stechen = new Scene(pane);
            window.setScene(stechen);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // DIALOGS

    public void showDialog(String fxmlPath, String title, boolean setNetworkListener) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(fxmlPath));
            VBox page = loader.load();

            // Create the dialog Stage.
            dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(window);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogViewController = loader.getController();
            dialogViewController.mainApp = this;
            if(networkClient != null &&  setNetworkListener) {
                networkClient.setNetworkListener(dialogViewController);
            }

            // Show the dialog and wait until the user closes it
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // NETWORKING

    public boolean connect(String host, int port) {
        connected = true;
        try {
            networkClient = new NetworkClient(this, host, port);
            return true;
        } catch (IOException e) {
            connected = false;
            System.err.println("Connection failed");
        }
        return false;
    }

    public void disconnect() {
        connected = false;
        networkClient.close();
    }

    public void sendPacket(PacketOut packet) {
        networkClient.send(JSONConverter.toJSON(new Container(new Timestamp(System.currentTimeMillis()).toString(),JSONConverter.getPayloadType(packet),JSONConverter.toJSONElement(packet))));
    }
}
