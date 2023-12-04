package de.thm.oop.chat.receiver;

import java.util.ArrayList;

public class Group extends Receiver {
    private ArrayList<Receiver> members = new ArrayList<>();

    public Group(String[] members, String groupName) {
        super(groupName);
        for (String member : members) {
            this.members.add(new Receiver(member));
        }
    }

    public ArrayList<Receiver> getMembers() {
        return members;
    }
}