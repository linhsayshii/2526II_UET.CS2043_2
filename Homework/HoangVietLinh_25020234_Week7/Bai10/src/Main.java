public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(() -> worker.run());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
        worker.stop();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
