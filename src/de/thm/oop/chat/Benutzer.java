package de.thm.oop.chat;

import de.thm.oop.chat.empfaenger.Empfaenger;

public class Benutzer extends Empfaenger {
    private String benutzername;
    private String passwort;

    public Benutzer(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }
}
