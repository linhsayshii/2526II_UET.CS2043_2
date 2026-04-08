public class SmsNotifier extends NotifierDecorator {
    public SmsNotifier(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notifier: " + message);
    }
}
