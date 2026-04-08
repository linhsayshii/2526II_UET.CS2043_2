public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SmsNotifier(emailNotifier);
        Notifier facebookNotifier = new FacebookNotifier(smsNotifier);
        facebookNotifier.send("Hello");
    }
}
