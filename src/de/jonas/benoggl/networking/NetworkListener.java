package de.jonas.benoggl.networking;

import de.jonas.benoggl.json.in.GameFinish;
import de.jonas.benoggl.json.in.GameStart;
import de.jonas.benoggl.json.in.JoinResponse;
import de.jonas.benoggl.json.in.LobbySnapshot;
import de.jonas.benoggl.json.in.MeldenSnapshot;
import de.jonas.benoggl.json.in.Next;
import de.jonas.benoggl.json.in.ReizenFinish;
import de.jonas.benoggl.json.in.ReizenSnapshot;
import de.jonas.benoggl.json.in.RoundFinish;
import de.jonas.benoggl.json.in.RoundStart;
import de.jonas.benoggl.json.in.StechenSnapshot;

public interface NetworkListener {

    void onGameFinish(GameFinish gameFinish);

    void onGameStart(GameStart gameStart);

    void onJoinResponse(JoinResponse joinResponse);

    void onLobbySnapshot(LobbySnapshot lobbySnapshot);

    void onMeldenSnapshot(MeldenSnapshot meldenSnapshot);

    void onNext(Next next);

    void onReizenFinish(ReizenFinish reizenFinish);

    void onReizenSnapshot(ReizenSnapshot reizenSnapshot);

    void onRoundFinish(RoundFinish roundFinish);

    void onRoundStart(RoundStart roundStart);

    void onStechenSnapshot(StechenSnapshot stechenSnapshot);
}
