package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import java.io.IOException;

public class Text extends Message {
    private String text;

    public Text(String receiverName, String text){
        super(receiverName);
        this.text = text;
    }

    public Text(String receiverName, String timestamp, int id, boolean out, String text){
        super(receiverName, timestamp, id, out);
        this.text = text;
    }

    @Override
    // Schlecht, da "send" bei Bild nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(User user) {
        try{
            super.getServer().sendTextMessage(user.getUsername(), user.getPassword(), super.getReceiver().getName(), text);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("An unexpected error has occurred.");
        }
    }

    @Override
    public String toString() {
        return "MessageID: " + super.getId() + " | " + super.getTimestamp() + " | '" + this.text + "' | " + (super.isOut() ? "send to " : "received from ") + super.getReceiver().getName();
    }
}
