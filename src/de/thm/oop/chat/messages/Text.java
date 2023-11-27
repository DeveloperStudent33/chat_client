package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.receiver.Receiver;

import java.io.IOException;

public class Text extends Message {
    private String text;

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(User user, Receiver receiver) {
        try{
            super.getServer().sendTextMessage(user.getBenutzername(), user.getPasswort(), receiver.getName(), text);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
