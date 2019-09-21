package de.jonas.benoggl.networking;

import de.jonas.benoggl.MainApp;
import de.jonas.benoggl.json.Container;
import de.jonas.benoggl.json.JSONConverter;
import de.jonas.benoggl.json.out.Ping;

import java.io.IOException;
import java.net.Socket;
import java.sql.Timestamp;

import static java.lang.Thread.sleep;

public class NetworkClient {

    private MainApp mainApp;
    private long lastPing;
    private Connection con;
    private NetworkListener listener;
    private PacketHandler handler;

    public NetworkClient(MainApp mainApp, String host, int port) throws IOException {
        lastPing = 0;
        this.mainApp = mainApp;
        try {
           con = new Connection(new Socket(host,port));
           handler = new PacketHandler(this);
           start();
        } catch (IOException e) {
            throw e;
        }

    }

    public void start() {
        run();
    }

    public void run() {
        Thread eventHandler = new Thread(new Runnable() {
            @Override
            public void run() {
                while (mainApp.connected) {
                    long time = System.currentTimeMillis();
                    if(time > lastPing + 9000) {
                        sendPing(time);
                        lastPing = time;
                    }
                    try {
                        String msg = con.readLine();
                        if(msg != null) {
                            handler.processMessage(msg);
                        }
                        sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        eventHandler.start();
    }

    private void sendPing(long time) {
        Container c = new Container(new Timestamp(time).toString(), "ping", JSONConverter.toJSONElement(new Ping("ping")));
        con.send(JSONConverter.toJSON(c));
    }

    public void setNetworkListener(NetworkListener listener) {
        this.listener = listener;
    }

    public NetworkListener getListener() {
        return listener;
    }

    public void close() {
        con.close();
    }

    public void send(String msg) {
        con.send(msg);
    }

    public String readLine()  {
        return con.readLine();
    }
}
