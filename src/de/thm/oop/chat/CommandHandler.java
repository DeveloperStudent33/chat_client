package de.thm.oop.chat;

import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.messages.Message;
import de.thm.oop.chat.messages.Picture;
import de.thm.oop.chat.messages.Text;
import de.thm.oop.chat.receiver.Group;
import de.thm.oop.chat.receiver.SingleReceiver;

import java.io.IOException;
import java.util.ArrayList;

public class CommandHandler extends ChatClient{
    BasicTHMChatServer server = new BasicTHMChatServer();

    public CommandHandler(){
        while (super.isActive()){
            String input = super.getInput().nextLine();
            commandAuswahl(filterCommand(input));
        }
    }

    public String[] filterCommand(String input) {
        return input.split(" ");
    }

    public void commandAuswahl(String[] inputFiltered) {
        switch (inputFiltered[0]) {
            case "msg" -> this.msg(inputFiltered);
            case "msgG" -> System.out.println("msgG");
            case "msgP" -> this.msgP(inputFiltered[1], inputFiltered[2]);
            case "msgGP" -> this.msgGP(inputFiltered[1], inputFiltered[2]);
            case "help" -> this.help();
            case "getMsg" -> this.getmsg();
            case "getUsers" -> this.getUsers();
            case "createGroup" -> this.createGroup(inputFiltered);
            case "getGroups" -> this.getGroups();
            case "exit" -> super.setActive();
            default -> System.out.println("Command could not be found.");
        }
    }

    public void help() {
        System.out.print("Platzhalter");
    }

    public void createGroup(String[] inputFiltered) { //Name
        String[] groupMembers = new String[inputFiltered.length-1];
        for (int i = 1; i < inputFiltered.length; i++) {
            groupMembers[i-1] = inputFiltered[i];
        }

        String groupName = inputFiltered[1];
        Group group = new Group(groupMembers, groupName);
        allGroups.add(group);
        System.out.println("Group was created.");
    }

    public void msg(String[] inputFiltered) {

    }

    public void msgP(String argument1, String argument2){
        SingleReceiver receiver = new SingleReceiver(argument1);
        Picture picture = new Picture(receiver, argument2);
        picture.send(super.getUser());
    }

    public void msgGP(String argument1, String argument2) {
        for (Group group : allGroups) {
            if (group.getName().equalsIgnoreCase(argument1)) {
                for (int i = 0; i < group.getMembers().size(); i++) {
                    this.msgP(group.getMembers().get(i).getName(), argument2);
                }
            } else {
                System.out.println("The group could not be found!");
            }
        }
    }

    public void getUsers() {
        //String[] allUsers =  server.getUsers(super.getUser().getUsername(), super.getUser().getPassword());
        try {
            String[] allUsers = server.getUsers(super.getUser().getUsername(), super.getUser().getPassword());
            System.out.println("User:");
            for (String user : allUsers) {
                System.out.println(user);
            }
        } catch (IOException e) {
            System.out.println("An unexpected error has occurred.");
        }
            // server.getUsers(...) ausführen und das zurückgelieferte Array speichern
            // das Array ausgeben (alle Strings mit "println" ausgeben)

    }

    public void getGroups() { //nochmal gucken
        for (Group group : allGroups) {
            System.out.println(group.getName() + ":");
            for (int i = 1; i < group.getMembers().size(); i++) {
                System.out.println("    " + (i) + ". " + group.getMembers().get(i).getName());
            }
        }
    }
}
