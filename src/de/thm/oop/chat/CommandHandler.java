package de.thm.oop.chat;

import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.messages.Message;
import de.thm.oop.chat.messages.Picture;
import de.thm.oop.chat.messages.Text;
import de.thm.oop.chat.receiver.Group;
import de.thm.oop.chat.receiver.Receiver;

import java.io.IOException;
import java.util.ArrayList;

public class CommandHandler extends ChatClient{
    BasicTHMChatServer server = new BasicTHMChatServer();
    private ArrayList<Group> allGroups = new ArrayList<Group>();

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
        System.out.println("User\n" +
                "- msg           -> Individual message -> msg [Receiver] [message] (Sends a message)\n" +
                "- msgG          -> Group message\n" +
                "- msgP          -> Picture message\n" +
                "- msgGP         -> Group picture message\n" +
                "- help          -> Instruction declaration\n" +
                "- getMsg        -> Get messages [Retrieve all messages]\n" +
                "- getUsers      -> Get all users [Retrieving a list of users (= potential chat partners]\n" +
                "- createGroup   -> Create a group -> Group only has to live while the program is on -> can be forgotten directly\n" +
                "- getGroups     -> Displays all groups (?)\n" +
                "- exit          -> Close/Cancel program");
    }

    public void createGroup(String[] inputFiltered) {
        String[] groupMembers = new String[inputFiltered.length - 1];
        for (int i = 0; i < groupMembers.length; i++) {
            groupMembers[i] = inputFiltered[i + 1];
        }

        String groupName = inputFiltered[1];
        Group group = new Group(groupMembers, groupName);
        allGroups.add(group);
        System.out.println("Group was created.");
    }

    public void msg(String[] inputFiltered) {
        Receiver receiver = new Receiver(inputFiltered[1]);

    }

    public void msgP(String argument1, String argument2){
        Receiver receiver = new Receiver(argument1);
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

    // Nachrichten auch mit Eingang oder Ausgang ausgeben
    // --> jede Nachricht als ein Objekt!!!!!!!!!!!!!!
    public void getmsg() {
        String[] allMessages = new String[100];
        // Server connection
        try {
            allMessages = server.getMostRecentMessages(super.getUser().getUsername(), super.getUser().getPassword());
        } catch (IOException e) {
            System.out.println("An unexpected error has occurred.");
        }

        for(int i = 0; i < allMessages.length; i++){
            String[] splitMessage = allMessages[i].split("\\|");
            // Save Messages to Objects
            ArrayList<Message> messages = new ArrayList<Message>();
            if(splitMessage[4].equals("img")){
                messages.add(new Picture(splitMessage[3], splitMessage[1], Integer.parseInt(splitMessage[0]), false, splitMessage[7], splitMessage[5]));
            } else {
                messages.add(new Text(splitMessage[3], splitMessage[1], Integer.parseInt(splitMessage[0]), false, splitMessage[5]));
            }

            for(Message msgs : messages){
                System.out.println(msgs.toString());
            }

           /* System.out.println("Message-ID: " + splitMessage[0]);
            System.out.println("Time: " + splitMessage[1]);
            System.out.println("Direction: " + splitMessage[2]);
            System.out.println("Chat partner: " + splitMessage[3]);
            System.out.println("Message Type: " + splitMessage[4]);*/
        }

        //id    |timestamp          |direction ("in" or "out")|chat partner (sender/receiver)  |message type ("txt" or "img")|
        //101112|2023-11-28 12:27:04|out                      |nmueller                        |img                          |image/png|19519|http://turing.iem.thm.de/chatJava/uploadedImages/6565ce88f1b71.png
    }
}
