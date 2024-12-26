package pub.sub.publisher;

public class PublisherThread extends Thread {
    private final Publisher1 publisher;

    public PublisherThread(Publisher1 publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run() {
        while(true) {
            int message = (int)(Math.random()*10);
            publisher.publish(String.valueOf(message));
            System.out.println("producer produced: " + message);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ignored) {

            }
        }
    }
}
