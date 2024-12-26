package pub.sub.broker;

public class BrokerThread extends Thread {
    private final Broker broker;

    public BrokerThread(Broker broker) {
        this.broker = broker;
    }
    @Override
    public void run() {
        while (true) {
            try {
                broker.publishFromQueue();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
