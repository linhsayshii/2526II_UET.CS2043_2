import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    ReentrantLock lock = new ReentrantLock();

    public void increment() {
        while (true) {
            if (lock.tryLock()) {
                try {
                    value++;
                    break;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public int getValue() {
        return value;
    }
}
