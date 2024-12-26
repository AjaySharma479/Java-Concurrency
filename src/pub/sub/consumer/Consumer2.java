package pub.sub.consumer;

import pub.sub.broker.Broker;

public class Consumer2 implements IConsumer {
    private static final String NAME = "Consumer-2";
    private final Broker broker;
    public Consumer2(Broker broker) {
        this.broker = broker;
    }
    @Override
    public void consume(String message) {
        System.out.println(NAME + " received message: " + message);
    }

    public void subscribe(String topic) {
        broker.subscribe(topic, this);
    }

    public void unsubscribe(String topic) {
        broker.unsubscribe(topic, this);
    }
}
