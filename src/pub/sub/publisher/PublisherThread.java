package pub.sub.publisher;

public class PublisherThread extends Thread {
    private final Publisher1 publisher;

    public PublisherThread(Publisher1 publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run() {
        while(true) {
            publisher.publish("Hi there! " + (int)(Math.random()*10));
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ignored) {

            }
        }
    }
}
