package Server.EventHandling;

import Server.networking.entities.User;

public interface EventListener {
    void onMessageReceived(User u, String message);

    void onUserJoined(User u);

    void onUserDisconnected(User u);
}