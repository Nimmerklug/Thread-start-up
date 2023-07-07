package Challenges.Test31;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int counter=0;
    private static Lock lock=new ReentrantLock();

    private static void increment(){
        lock.lock();
        try { //just in case if three will be any exception
            for (int i = 0; i < 1000000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }

    private static void add(){
        lock.unlock();
    }

    public static void main(String[] args) {

        System.out.println("*** Starting ***");
        for (int i=0;i<10;i++) {
            counter=0;
            Thread t1 = new Thread(Main::increment);
            Thread t2 = new Thread(Main::increment);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(counter);
        }

        System.out.println("*** Finishing ***");

    }
}