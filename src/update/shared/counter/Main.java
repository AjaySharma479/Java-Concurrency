package update.shared.counter;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 10;
        CounterThread[] threads = new CounterThread[NUMBER_OF_THREADS];
        Counter counter = new Counter();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("UpdateSharedCounter.Counter: " + counter.getCounter());
    }
}
