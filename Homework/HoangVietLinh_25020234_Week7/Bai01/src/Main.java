public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Task 1", 2000));
        Thread thread2 = new Thread(new Task("Task 2", 3000));
        
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
            Thread.currentThread().interrupt(); // Preserve interrupt status
        } finally {
            System.out.println("All tasks completed.");
        }
    }
}
