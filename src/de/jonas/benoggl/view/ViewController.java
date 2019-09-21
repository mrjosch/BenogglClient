package de.jonas.benoggl.view;

import de.jonas.benoggl.MainApp;
import de.jonas.benoggl.json.in.*;
import de.jonas.benoggl.networking.NetworkListener;

public abstract class ViewController implements NetworkListener {

    // Reference to the main application.
    public MainApp mainApp;

    public abstract void init(Object...params);

    @Override
    public void onGameFinish(GameFinish gameFinish) {

    }

    @Override
    public void onGameStart(GameStart gameStart) {

    }

    @Override
    public void onJoinResponse(JoinResponse joinResponse) {

    }

    @Override
    public void onLobbySnapshot(LobbySnapshot lobbySnapshot) {

    }

    @Override
    public void onMeldenSnapshot(MeldenSnapshot meldenSnapshot) {

    }

    @Override
    public void onNext(Next next) {

    }

    @Override
    public void onReizenFinish(ReizenFinish reizenFinish) {

    }

    @Override
    public void onReizenSnapshot(ReizenSnapshot reizenSnapshot) {

    }

    @Override
    public void onRoundFinish(RoundFinish roundFinish) {

    }

    @Override
    public void onRoundStart(RoundStart roundStart) {

    }

    @Override
    public void onStechenSnapshot(StechenSnapshot stechenSnapshot) {

    }
}
