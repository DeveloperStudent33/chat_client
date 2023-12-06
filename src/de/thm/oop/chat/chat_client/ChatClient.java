package de.thm.oop.chat.chat_client;

import java.io.IOException;
import java.util.Scanner;
import de.thm.oop.chat.base.server.BasicTHMChatServer;

public class ChatClient {
    private User user;
    private boolean active;

    public ChatClient() {
        getData();
        active = true;
    }

    public void getData(){
        Scanner inputScanner = new Scanner(System.in);
        String username;
        String password;
        do {
            System.out.print("Please enter your username: ");
            username = inputScanner.next();
            System.out.print("Please enter your password: ");
            password = inputScanner.next();
        } while (!this.checkData(username, password));

        user = new User(username, password);
        System.out.println("Logged in as " + username + "!");
    }

    public boolean checkData(String username, String password){
        BasicTHMChatServer server = new BasicTHMChatServer();
        try{
            server.getMessages(username, password, 0);
        } catch (IOException | IllegalArgumentException e){
            System.out.println("The username or password is incorrect!");
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
}
