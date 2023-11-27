package de.thm.oop.chat;

import de.thm.oop.chat.receiver.Receiver;
import de.thm.oop.chat.receiver.Group;

import java.util.ArrayList;

public class CommandHandler {
    private Group group;

    public String[] filterCommand(String input) {
        return input.split(" ");
    }

    /*public void filterCommand(String input) {
        String[] eingabe = input.split(" ");
        System.out.println("TEST" + eingabe.length);
        for (int i = 0; i < eingabe.length; i++) {
            System.out.print(eingabe[i] + " : ");
            System.out.print(i);
        }
        //System.out.println(eingabe[2]);
    }*/

    public void filterXCommand(String input) {
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' '){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
        //String[] subStrings =
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
        String[] groupMembers = new String[((inputFiltered.length))];
        for (int i = 0; i < groupMembers.length; i++) {
            groupMembers[i] = inputFiltered[i + 1];
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
        for (int i = 0; i <= group.getMembers().size(); i++) {
            for (Receiver member : group.getMembers()) {
                System.out.println(i + 1 + ". " + member.getName());
            }
        }

    }
}
