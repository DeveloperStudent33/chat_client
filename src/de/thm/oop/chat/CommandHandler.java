package de.thm.oop.chat;

import de.thm.oop.chat.receiver.Receiver;
import de.thm.oop.chat.receiver.Group;

import java.util.ArrayList;

public class CommandHandler {
    private Group group;

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
                System.out.println("msgP");
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
                System.out.println("exit");
                //super.setAktiv();
                //funktioniert vorerst nicht --> Später überlegen --> kann man eine Methode der Unterklasse von der Oberklasse aus aufrufen (Objekt vorher initianlisert)
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

    public void msg(String[] eingabeGefiltert) {

    }

    public void getGroup() {
        for (int i = 0; i < group.getMembers().size(); i++){
            System.out.println(i + 1 + ". " + group.getMembers().get(i).getName());
        }
    }
}
