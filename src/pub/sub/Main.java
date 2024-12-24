package pub.sub;

import pub.sub.broker.Broker;
import pub.sub.broker.BrokerThread;
import pub.sub.consumer.Consumer1;
import pub.sub.consumer.Consumer2;
import pub.sub.publisher.Publisher1;
import pub.sub.publisher.PublisherThread;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        BrokerThread brokerThread = new BrokerThread(broker);
        brokerThread.start();

        Consumer1 consumer1 = new Consumer1(broker);
        Consumer2 consumer2 = new Consumer2(broker);

        consumer1.subscribe("topic-publisher-1");
        consumer2.subscribe("topic-publisher-1");

        Publisher1 publisher1 = new Publisher1(broker);
        PublisherThread publisherThread = new PublisherThread(publisher1);

        publisherThread.start();
    }
}
