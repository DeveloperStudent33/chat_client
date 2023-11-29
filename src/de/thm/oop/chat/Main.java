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

        /*BasicTHMChatServer server = new BasicTHMChatServer();
        String[] allMessages = new String[100];
        try {
            allMessages = server.getMostRecentMessages("nmueller", "Ok16m8rx");
        } catch (IOException e) {
            System.out.println("An unexpected error has occurred.");
        }

        for(int i = 0; i < allMessages.length; i++){
            String[] splitMessage = allMessages[i].split("\\|");

            System.out.println("Message-ID: " + splitMessage[0]);
            System.out.println("Time: " + splitMessage[1]);
            System.out.println("Direction: " + splitMessage[2]);
            System.out.println("Chat partner: " + splitMessage[3]);
            System.out.println("Message Type: " + splitMessage[4]);
            System.out.println("wasdas1: " + splitMessage[5]);
            System.out.println("wasdas2: " + splitMessage[6]);
            System.out.println("wasdas3: " + splitMessage[7]);
        }*/
    }
}