package pub.sub.broker;

import pub.sub.consumer.IConsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Broker {
    private final Map<String, List<IConsumer>> topicToConsumersMap = new HashMap<>();
    private final Queue<QueueMessage> messageQueue = new LinkedList<>();
    private final int QUEUE_MAXIMUM_SIZE = 10;

    public void publish(String message, String topic) {
        messageQueue.add(new QueueMessage(topic, message));
    }

    public void subscribe(String topic, IConsumer consumer) {
        if(!this.topicToConsumersMap.containsKey(topic)) {
            this.topicToConsumersMap.put(topic, new ArrayList<>());
        }
        this.topicToConsumersMap.get(topic).add(consumer);
    }

    public void unsubscribe(String topic, IConsumer consumer) {
        this.topicToConsumersMap.get(topic).remove(consumer);
    }

    public void publishFromQueue() {
        if(messageQueue.isEmpty()) return;
        QueueMessage queueMessage = messageQueue.poll();
        List<IConsumer> topicConsumers = topicToConsumersMap.get(queueMessage.getTopic());
        if (topicConsumers != null) {
            for (IConsumer consumer : topicConsumers) {
                consumer.consume(queueMessage.getMessage());
            }
        }
    }

    private static class QueueMessage {
        private final String topic;
        private final String message;

        public QueueMessage(String topic, String message) {
            this.topic = topic;
            this.message = message;
        }

        public String getTopic() {
            return this.topic;
        }
        public String getMessage() {
            return this.message;
        }
    }
}
