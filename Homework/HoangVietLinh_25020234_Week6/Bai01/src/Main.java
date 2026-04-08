public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println("Thread 1: " + config.hashCode());
        });
        Thread thread2 = new Thread(() -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println("Thread 2: " + config.hashCode());
        });
        thread1.start();
        thread2.start();
    }
}
