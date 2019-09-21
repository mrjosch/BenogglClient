package de.jonas.benoggl.networking;

import com.google.gson.JsonSyntaxException;
import de.jonas.benoggl.json.Container;
import de.jonas.benoggl.json.JSONConverter;
import de.jonas.benoggl.json.in.*;
import javafx.application.Platform;


public class PacketHandler {

    private NetworkClient networkClient;

    public PacketHandler(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public void processMessage(String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Container c = (Container) JSONConverter.toObject(msg, Container.class);
                    if(c.payloadType.equals("lobbySnapshot")) {
                        LobbySnapshot obj = (LobbySnapshot) JSONConverter.toObject(c.payload, LobbySnapshot.class);
                        networkClient.getListener().onLobbySnapshot(obj);
                    } else if(c.payloadType.equals("joinResponse")) {
                        JoinResponse obj = (JoinResponse) JSONConverter.toObject(c.payload, JoinResponse.class);
                        networkClient.getListener().onJoinResponse(obj);
                    } else if(c.payloadType.equals("gameStart")) {
                        GameStart obj = (GameStart) JSONConverter.toObject(c.payload, GameStart.class);
                        networkClient.getListener().onGameStart(obj);
                    } else if(c.payloadType.equals("roundStart")) {
                        RoundStart obj = (RoundStart) JSONConverter.toObject(c.payload, RoundStart.class);
                        networkClient.getListener().onRoundStart(obj);
                    } else if(c.payloadType.equals("next")) {
                        Next obj = (Next) JSONConverter.toObject(c.payload, Next.class);
                        networkClient.getListener().onNext(obj);
                    } else if(c.payloadType.equals("reizenSnapshot")) {
                        ReizenSnapshot obj = (ReizenSnapshot) JSONConverter.toObject(c.payload, ReizenSnapshot.class);
                        networkClient.getListener().onReizenSnapshot(obj);
                    } else if(c.payloadType.equals("reizenFinish")) {
                        ReizenFinish obj = (ReizenFinish) JSONConverter.toObject(c.payload, ReizenFinish.class);
                        networkClient.getListener().onReizenFinish(obj);
                    } else if(c.payloadType.equals("meldenSnapshot")) {
                        MeldenSnapshot obj = (MeldenSnapshot) JSONConverter.toObject(c.payload, MeldenSnapshot.class);
                        networkClient.getListener().onMeldenSnapshot(obj);
                    } else if(c.payloadType.equals("stechenSnapshot")) {
                        StechenSnapshot obj = (StechenSnapshot) JSONConverter.toObject(c.payload, StechenSnapshot.class);
                        networkClient.getListener().onStechenSnapshot(obj);
                    } else if(c.payloadType.equals("roundFinish")) {
                        RoundFinish obj = (RoundFinish) JSONConverter.toObject(c.payload, RoundFinish.class);
                        networkClient.getListener().onRoundFinish(obj);
                    } else if(c.payloadType.equals("gameFinish")) {
                        GameFinish obj = (GameFinish) JSONConverter.toObject(c.payload, GameFinish.class);
                        networkClient.getListener().onGameFinish(obj);
                    } else {
                        System.err.println(c.timestamp + " | Unknown Message of Type: " + c.payloadType + " Payload: " + c.payload);
                    }
                } catch (Exception e) {
                    if(e instanceof JsonSyntaxException) {
                        System.out.println("JsonSyntaxException!! -- THIS SHOULD NOT HAPPEN");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
