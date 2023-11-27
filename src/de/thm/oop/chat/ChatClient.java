package de.thm.oop.chat;

import java.io.IOException;
import java.util.Scanner;
import de.thm.oop.chat.base.server.BasicTHMChatServer;

public class ChatClient {
    private User user;
    private Scanner eingabe = new Scanner(System.in);
    private boolean aktiv;

    public ChatClient() {
        aktiv = true;
        getData();
        CommandHandler commands = new CommandHandler();
        while (aktiv){
            String eingabe = this.eingabe.nextLine();
            commands.commandAuswahl(commands.filterCommand(eingabe));
        }
    }

    public void getData(){
        String nutzername = "";
        String passwort = "";
        do {
            System.out.print("Bitte geben Sie ihren Nutzernamen ein: ");
            nutzername = eingabe.next();
            System.out.print("Bitte geben Sie ihr Passwort ein: ");
            passwort = eingabe.next();
        } while (!this.checkData(nutzername, passwort));

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

    public User getBenutzer() {
        return user;
    }

    public void setAktiv() {
        this.aktiv = !aktiv;
    }
}
