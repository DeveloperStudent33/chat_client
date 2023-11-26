package de.thm.oop.chat.nachrichten;

import de.thm.oop.chat.Benutzer;
import de.thm.oop.chat.empfaenger.Empfaenger;
import java.io.IOException;
import java.io.InputStream;

public class Bild extends Nachricht {
    private String mimeType;
    private InputStream input;

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(Benutzer benutzer, Empfaenger empfaenger) {
        try{
            super.getServer().sendImageMessage(benutzer.getBenutzername(), benutzer.getPasswort(), empfaenger.getName(), mimeType, input);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
