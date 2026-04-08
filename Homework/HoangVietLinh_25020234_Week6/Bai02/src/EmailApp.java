public class EmailApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
