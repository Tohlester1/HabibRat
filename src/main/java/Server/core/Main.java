package Server.core;

import Server.EventHandling.EventListener;
import Server.EventHandling.Initiater;
import Server.networking.entities.User;

public class Main implements EventListener {

    public static Initiater init = new Initiater();

    public static void main(String[] args) {
        init.SetupListeners();
    }

    public void onUserJoined(User u) {
        System.out.println(u.IP + " joined!");
    }

    public void onMessageReceived(User u, String msg) {

    }

    public void onUserDisconnected(User u) {

    }
}