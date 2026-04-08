public class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Facebook Notifier: " + message);
    }
}
