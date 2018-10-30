package Server.networking.entities;

import Server.core.Main;

import java.io.*;
import java.net.Socket;

public class User {

    private Socket s;
    private BufferedReader br;
    private BufferedWriter bw;
    public  int UserID;
    public boolean Connected;
    public String IP;
    private User user = this;
    private String text;

    public void Start(Socket sock) throws IOException {
        this.s = sock;
        Connected = true;
        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        this.IP = s.getInetAddress().getHostAddress();
        Listener lst = new Listener();
        Thread thr = new Thread(lst);
        thr.start();
    }

    private class Listener implements Runnable {

        public void run() {
            while(Connected = true) {
                try {
                
                } catch (Exception ex) {
                    Connected = false;
                    Main.init.UserDisconnected(user);
                }
            }
        }
    }
}