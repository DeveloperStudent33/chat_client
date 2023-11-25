package de.thm.oop.chat.nachrichten;

import de.thm.oop.chat.Benutzer;
import de.thm.oop.chat.empfaenger.Empfaenger;

import java.io.IOException;

public class Text extends Nachricht {
    private String text;

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(Benutzer benutzer, Empfaenger empfaenger) {
        try{
            super.getServer().sendTextMessage(benutzer.getBenutzername(), benutzer.getPasswort(), empfaenger.getName(), text);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
