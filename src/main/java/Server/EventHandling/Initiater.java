package Server.EventHandling;

import Server.core.Main;
import Server.networking.entities.User;

import java.util.ArrayList;

public class Initiater {

    private ArrayList<EventListener> listeners = new ArrayList<EventListener>();

    public Initiater() {
        SetupListeners();
    }

    public void addListener(EventListener lst) {
        listeners.add(lst);
    }

    public void MessageReceived(User u, String message) {
        for (EventListener eventListener : listeners) {
            eventListener.onMessageReceived(u, message);
        }
    }

    public void UserDisconnected(User u) {
        for (EventListener eventListener : listeners) {
            eventListener.onUserDisconnected(u);
        }
    }

    public void UserJoined(User u) {
        for (EventListener eventListener : listeners) {
            eventListener.onUserJoined(u);
        }
    }

    public void SetupListeners() {
        addListener(new Main());
    }
}