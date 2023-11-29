package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.receiver.Receiver;

public abstract class Message {
    private Receiver receiver;
    private  String receiverName;
    private String timestamp;
    private int id;
    private boolean out;
    private BasicTHMChatServer server = new BasicTHMChatServer();

    public Message(Receiver receiver){
        this.receiver = receiver;
        this.out = true;
    }

    public Message(String receiverName, String timestamp, int id, boolean out){
        this.receiverName = receiverName;
        this.timestamp = timestamp;
        this.id = id;
        this.out = out;
    }

    public abstract void send(User user);

    public abstract String toString();

    public BasicTHMChatServer getServer() {
        return server;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public boolean isOut() {
        return out;
    }
}
