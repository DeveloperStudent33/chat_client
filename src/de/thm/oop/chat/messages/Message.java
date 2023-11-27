package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.receiver.Receiver;

public abstract class Message {
    private Receiver receiver;
    private BasicTHMChatServer server = new BasicTHMChatServer();

    public abstract void send(User user, Receiver receiver);

    public BasicTHMChatServer getServer() {
        return server;
    }
}
