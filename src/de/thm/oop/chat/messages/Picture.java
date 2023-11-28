package de.thm.oop.chat.messages;

import de.thm.oop.chat.User;
import de.thm.oop.chat.receiver.Receiver;
import java.io.*;
import java.nio.file.Files;

public class Picture extends Message {
    private String mimeType;
    private InputStream input;

    public Picture(Receiver receiver){
        super(receiver);
        try{
            File picture = new File("pic/testbild.png");
            //Inspiriert von https://www.baeldung.com/java-file-mime-type
            mimeType = Files.probeContentType(picture.toPath());
            input = new FileInputStream(picture);
        } catch (FileNotFoundException e) {
            System.out.println("Es konnte leider keine Datei zum hochladen gefunden werden");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    // Schlecht, da "send" bei Text nahzu identisch --> womöglich Teilweise in Nachricht integrieren??
    public void send(User user) {
        try{
            // da muss ein if mit "instanceof" (siehe Screencasts), obs eine Gruppe oder ein Singlereceiver ist --> das muss in COmmand Handler
            super.getServer().sendImageMessage(user.getBenutzername(), user.getPasswort(), super.getReceiver().getName(), mimeType, input);
            System.out.println("Bild gesendet");
        } catch (IOException | IllegalArgumentException e){
            System.out.println("Ein unerwarteter Fehler ist aufgetreten");
        }
    }
}
