package de.thm.oop.chat.receiver;

public class SingleReceiver extends Receiver{
    private String name;

    public SingleReceiver(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
