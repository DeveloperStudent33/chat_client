package de.thm.oop.chat;

import java.io.IOException;
import java.util.Scanner;
import de.thm.oop.chat.base.server.BasicTHMChatServer;

public class ChatClient {
    private User user;
    private Scanner input = new Scanner(System.in);
    private boolean active;

    public ChatClient() {
        active = true;
        getData();
    }

    public void getData(){
        String nutzername = "nmueller";
        String passwort = "Ok16m8rx";
        /*String nutzername = "";
        String passwort = "";
        do {
            System.out.print("Bitte geben Sie ihren Nutzernamen ein: ");
            nutzername = input.next();
            System.out.print("Bitte geben Sie ihr Passwort ein: ");
            passwort = input.next();
        } while (!this.checkData(nutzername, passwort));*/

        user = new User(nutzername, passwort);
    }

    public boolean checkData(String nutzername, String passwort){
        BasicTHMChatServer server = new BasicTHMChatServer();
        try{
            server.getMessages(nutzername, passwort, 0);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Der Benutzername oder das Passwort sind leider falsch!");
            return false;
        }
        return true;
    }

    public User getUser() {
        return user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        this.active = !active;
    }

    public Scanner getInput() {
        return input;
    }
}
