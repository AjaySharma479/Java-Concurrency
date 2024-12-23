package update.shared.counter;

public class Counter {
    int counter = 0;

    public int getCounter() {
        return counter;
    }

    public synchronized void increment() {
        counter++;
    }
}
