public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.initBook("Java", 10);
        store.initBook("Python", 5);

        Runnable readTask = () -> {
            for (int i = 0; i<2; i++) {
                store.getStock("Java");
                try { Thread.sleep(200); } catch (InterruptedException e) {Thread.currentThread().interrupt(); }
            }
        };

        Thread r1 = new Thread(readTask, "Reader-1");
        Thread r2 = new Thread(readTask, "Reader-2");
        Thread r3 = new Thread(readTask, "Reader-3");

        Thread w1 = new Thread(() -> store.addBook("Java", 5), "Writer-1");
        Thread w2 = new Thread(() -> store.borrow("Java", 3), "Borrow-1");

        r1.start();
        r2.start();
        r3.start();
        try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        w1.start();
        w2.start();
    }
}
