package de.thm.oop.chat.receiver;

import java.util.ArrayList;

public class Group extends Receiver {
    private ArrayList<SingleReceiver> members = new ArrayList<SingleReceiver>();
    private String groupName;

    public Group(String[] members, String groupName) {
        for (String member : members) {
            this.members.add(new SingleReceiver(member));
        }
        this.groupName = groupName;
    }

    @Override
    public String getName() {
        return groupName;
    }

    public ArrayList<SingleReceiver> getMembers() {
        return members;
    }

}