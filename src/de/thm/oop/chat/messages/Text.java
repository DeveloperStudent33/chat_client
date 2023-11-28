package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.receiver.Receiver;

import java.io.IOException;

public class Text extends Message {
    private String text;

    public Text(Receiver receiver, String text){
        super(receiver);
        this.text = text;
    }
    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(User user) {
        try{
            super.getServer().sendTextMessage(user.getBenutzername(), user.getPasswort(), super.getReceiver().getName(), text);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
