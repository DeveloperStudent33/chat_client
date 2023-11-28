package de.thm.oop.chat;

import de.thm.oop.chat.base.server.BasicTHMChatServer;
import de.thm.oop.chat.messages.Picture;
import de.thm.oop.chat.receiver.Receiver;
import de.thm.oop.chat.receiver.Group;
import de.thm.oop.chat.receiver.SingleReceiver;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandHandler extends ChatClient{
    private Group group;
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
            case "msg": // Daniel
                System.out.println("msg");
                break;
            case "msgG": // Daniel
                System.out.println("msgG");
                break;
            case "msgP": // Niklas
                msgP(inputFiltered);
                break;
            case "msgGP": // Niklas
                System.out.println("msgGP");
                break;
            case "help": // Benni
                this.help();
                break;
            case "getMsg": // Katinka
                System.out.println("getMsg");
                break;
            case "getUsers": // Benni
                System.out.println("getUsers");
                break;
            case "createGroup": // Katinka
                this.createGroup(inputFiltered);
                break;
            case "getGroup": // Katinka
                getGroup();
                break;
            case "exit":
                super.setActive();
                break;
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

        /*
        for (String inputs : inputFiltered) {

            groupMembers.add(new Receiver(inputs));
        }
        */

        group = new Group(groupMembers);
        System.out.println("Gruppe wurde erstellt");
    }

    public void msg(String[] inputFiltered) {

    }

    public void msgP(String[] inputFiltered){
        SingleReceiver receiver = new SingleReceiver(inputFiltered[1]);
        Picture picture = new Picture(receiver);
        picture.send(super.getUser());
    }

    public void msgGP(String[] inputFiltered){

    }

    public void getGroup() {
        for (int i = 0; i < group.getMembers().size(); i++){
            System.out.println(i + 1 + ". " + group.getMembers().get(i).getName());
        }
    }
}
