package UpdateSharedCounter;

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
                threads[i].interrupt();
                e.printStackTrace();
            }
        }
        System.out.println("UpdateSharedCounter.Counter: " + counter.getCounter());
    }
}

class CounterThread extends Thread {
    private Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    private void increment() {
        counter.setCounter(counter.getCounter() + 1);
    }
}

class Counter {
    int counter = 0;

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }

    public void setCounter(int counter) {
        synchronized (this) {
            this.counter = counter;
        }
    }
}
