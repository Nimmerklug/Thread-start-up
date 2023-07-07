package Challenges.Test33;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Starting ***");

        Worker worker = new Worker();

        Thread producer = new Thread(() -> {
            try {
                worker.fillList();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            try {
                worker.emptyList();
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