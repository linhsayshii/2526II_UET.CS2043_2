public abstract class NotificationApp {
    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
    public abstract Notification createNotification();
}
