package application.notification;

import java.util.ArrayList;

public abstract class Notifier {
    public ArrayList<Notifier> wrapper = new ArrayList<>();

    public abstract void send(String message);

    public String description = "Sending by...";
}
