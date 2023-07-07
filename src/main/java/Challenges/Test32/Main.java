package Challenges.Test32;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Starting ***");

        ProducerAndConsumer pc = new ProducerAndConsumer(20, 5);

        Thread producer = new Thread(() -> {
            try {
                pc.fillList();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            try {
                pc.emptyList();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("*** Finishing ***");

    }
}