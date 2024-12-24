package pub.sub.consumer;

import pub.sub.broker.Broker;

public class Consumer1 implements IConsumer {
    private static final String CONSUMER_NAME = "Consumer-1";
    private final Broker broker;

    public Consumer1(Broker broker) {
        this.broker = broker;
    }
    @Override
    public void consume(String message) {
        System.out.println(CONSUMER_NAME + " received message: " + message);
    }

    public void subscribe(String topic) {
        broker.subscribe(topic, this);
    }

    public void unsubscribe(String topic) {
        broker.unsubscribe(topic, this);
    }
}
