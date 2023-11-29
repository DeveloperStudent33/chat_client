package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.receiver.Receiver;
import java.io.*;
import java.nio.file.Files;

public class Picture extends Message {
    private String mimeType;
    private InputStream input;
    private String path;

    public Picture(Receiver receiver, String pictureName){
        super(receiver);
        try{
            File picture = new File("pic/" + pictureName);
            path = picture.toPath().toString();
            //Inspired by https://www.baeldung.com/java-file-mime-type
            mimeType = Files.probeContentType(picture.toPath());
            input = new FileInputStream(picture);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, no file could be found to upload.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Picture(String receiverName, String timestamp, int id, boolean out, String path, String mimeType){
        super(receiverName, timestamp, id, out);
        this.path = path;
        this.mimeType = mimeType;
    }

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Message integrieren??
    public void send(User user) {
        try{
            super.getServer().sendImageMessage(user.getUsername(), user.getPassword(), super.getReceiver().getName(), mimeType, input);
            System.out.println("Picture sent to " + super.getReceiver().getName() + ".");
        } catch (IOException | IllegalArgumentException e){
            System.out.println("An unexpected error has occurred.");
        }
    }

    @Override
    public String toString() {
        return "MessageID: " + super.getId() + " | " + super.getTimestamp() + " | '" + this.path + "' | " + (super.isOut() ? "received" : "send");
    }
}
