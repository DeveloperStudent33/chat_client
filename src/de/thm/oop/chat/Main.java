package de.thm.oop.chat;

import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.messages.Message;
import de.thm.oop.chat.messages.Picture;
import de.thm.oop.chat.messages.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //ChatClient client = new ChatClient();
        CommandHandler main = new CommandHandler();
    }
}