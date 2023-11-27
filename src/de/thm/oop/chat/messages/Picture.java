package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.receiver.Receiver;
import java.io.IOException;
import java.io.InputStream;

public class Picture extends Message {
    private String mimeType;
    private InputStream input;

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(User user, Receiver receiver) {
        try{
            // da muss ein if mit "instanceof" (siehe Screencats), obs eine Gruppe oder ein Singlereceiver ist
            super.getServer().sendImageMessage(user.getBenutzername(), user.getPasswort(), receiver.getName(), mimeType, input);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
