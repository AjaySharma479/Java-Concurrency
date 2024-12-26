package pub.sub;

import pub.sub.broker.Broker;
import pub.sub.broker.BrokerThread;
import pub.sub.consumer.Consumer1;
import pub.sub.publisher.Publisher1;
import pub.sub.publisher.PublisherThread;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        BrokerThread[] brokerThreads = new BrokerThread[10];
        for(int i = 0; i < 10; i++) {
            brokerThreads[i] = new BrokerThread(broker);
            brokerThreads[i].start();
        }

        Consumer1 consumer1 = new Consumer1(broker);

        consumer1.subscribe("topic-publisher-1");

        Publisher1 publisher1 = new Publisher1(broker);
        PublisherThread[] publisherThreads = new PublisherThread[20];
        for(int i = 0; i < 20; i++) {
            publisherThreads[i] = new PublisherThread(publisher1);
            publisherThreads[i].start();
        }
    }
}
