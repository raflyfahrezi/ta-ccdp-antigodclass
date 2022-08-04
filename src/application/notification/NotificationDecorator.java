package application.notification;

public class NotificationDecorator extends Notifier{

    @Override
    public void send(String message) {
        for (Notifier notifier: wrapper){
            ((KirimPaketNotification) notifier).sendPaket(message);
        }
    }
}
