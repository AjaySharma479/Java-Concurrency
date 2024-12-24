package pub.sub.publisher;

import pub.sub.broker.Broker;

public class Publisher1 implements IPublisher {

    private static final String TOPIC_NAME = "topic-publisher-1";
    private final Broker broker;

    public Publisher1(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(String message) {
        this.broker.publish(message, TOPIC_NAME);
    }
}
