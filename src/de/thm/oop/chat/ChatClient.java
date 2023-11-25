package de.thm.oop.chat;

import java.io.IOException;
import java.util.Scanner;
import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.commands.CommandHandler;

public class ChatClient {
    Benutzer benutzer;
    public ChatClient(){
        getData();
        CommandHandler commands = new CommandHandler();
    }

    public void getData(){
        Scanner sc = new Scanner(System.in);
        String nutzername = "";
        String passwort = "";
        do {
            System.out.print("Bitte geben Sie ihren Nutzernamen ein: ");
            nutzername = sc.next();
            System.out.print("Bitte geben Sie ihr Passwort ein: ");
            passwort = sc.next();
        } while (!checkData(nutzername, passwort));

        benutzer = new Benutzer(nutzername, passwort);
    }

    public boolean checkData(String nutzername, String passwort){
        BasicTHMChatServer server = new BasicTHMChatServer();
        try{
            server.getMessages(nutzername, passwort, 0);
        } catch (IOException e){
            System.out.println("Der Benutzername oder das Passwort sind leider falsch!");
            return false;
        }
        return true;
    }
}
