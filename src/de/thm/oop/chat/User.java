package de.thm.oop.chat;

public class User {
    private String benutzername;
    private String passwort;

    public User(String benutzername, String passwort) {
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
