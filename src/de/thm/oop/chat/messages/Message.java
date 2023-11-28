package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.receiver.Receiver;

public abstract class Message {
    private Receiver receiver;
    private BasicTHMChatServer server = new BasicTHMChatServer();

    public Message(Receiver receiver){
        this.receiver = receiver;
    }

    public abstract void send(User user);

    public BasicTHMChatServer getServer() {
        return server;
    }

    public Receiver getReceiver() {
        return receiver;
    }
}
