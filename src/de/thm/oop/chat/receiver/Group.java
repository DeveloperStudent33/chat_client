package de.thm.oop.chat.receiver;

import java.util.ArrayList;

public class Group extends Receiver {
    private ArrayList<SingleReceiver> members = new ArrayList<SingleReceiver>();
    private String groupName;

    public Group(String[] members) {
        for (String member : members) {
            this.members.add(new SingleReceiver(member));
        }
    }

    @Override
    public String getName(){
        return groupName;
    }
    public ArrayList<SingleReceiver> getMembers() {
        return members;
    }
}
