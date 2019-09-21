package de.jonas.benoggl.networking;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Connection {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private long time;
    private boolean ok;


    public Connection(Socket socket) {
        this.socket = socket;
        ok = true;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            out = new PrintWriter(socket.getOutputStream(), true);
            time = new Date().getTime();
        } catch (IOException e) {
            ok = false;
        }
    }

    public void send(String msg) {
        out.println(msg);
        System.out.println();
        System.out.println("Sent: " + msg);
        System.out.println();
    }

    public String readLine() {
        try {
            String line;
            if(in.ready()) {
                line = in.readLine();
                System.err.println();
                System.err.println("Received: " + line);
                System.err.println();
                return line;
            }
        } catch (IOException e) {
            System.err.println("Error -- Connection.java -- readLine()");
        }
        return null;
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isOk() {
        return ok;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Socket getSocket() {
        return socket;
    }

}
