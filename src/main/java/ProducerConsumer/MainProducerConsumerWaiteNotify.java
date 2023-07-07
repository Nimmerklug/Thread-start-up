package ProducerConsumer;

import java.util.LinkedList;

public class MainProducerConsumerWaiteNotify {
    public static void main(String[] args) {
        Task task = new Task(10);
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    task.produce();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    task.consume();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }
    private static class Task {

        private static int size;
        private LinkedList<String> linkedList = new LinkedList<>();

        public Task(int size) {
            this.size = size;
        }
        public synchronized void produce() throws InterruptedException {
            while (linkedList.size() == size) wait();
            System.out.println("Produced: " + linkedList.add("Something !!!") + ", Queue size: " + linkedList.size());
            notify();
        }
        public synchronized void consume() throws InterruptedException {
            while (linkedList.isEmpty()) wait();
            System.out.println("Consumed: " + linkedList.removeFirst() + ", Queue size: " + linkedList.size());
            notify();
        }
    }

}
