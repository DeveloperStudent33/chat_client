package de.thm.oop.chat.nachrichten;

import de.thm.oop.chat.Benutzer;
import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.empfaenger.Empfaenger;

public abstract class Nachricht {
    private Empfaenger empfaenger;
    private BasicTHMChatServer server = new BasicTHMChatServer();

    public abstract void send(Benutzer benutzer, Empfaenger empfaenger);

    public BasicTHMChatServer getServer() {
        return server;
    }
}
