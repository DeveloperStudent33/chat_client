package de.thm.oop.chat;

import de.thm.oop.chat.base.server.BasicTHMChatServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BasicTHMChatServer server = new BasicTHMChatServer();
        String[] user = server.getUsers("Matschipapp", "qW8MVkr9");
        for (String users: user) {
            System.out.println(users);
        }
    }
}