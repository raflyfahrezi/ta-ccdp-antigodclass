package application.notification;

import javax.swing.*;

public class KirimPaketNotification extends NotificationDecorator{
    public KirimPaketNotification(Notifier notifier) {
        this.description = notifier.description + " notifier";
        this.wrapper = notifier.wrapper;
        this.wrapper.add(this);
    }

    public void sendPaket(String message){
        JOptionPane.showMessageDialog(null, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
}
