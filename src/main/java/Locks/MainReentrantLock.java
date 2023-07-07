package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {

    public static void main(String[] args) {
        TryLock tryLock = new TryLock();
        new MyThread(tryLock).start();
        new MyThread(tryLock).start();
        new MyThread(tryLock).start();
    }

    private static class MyThread extends Thread {

        private TryLock tryLock;

        public MyThread(TryLock tryLock) {
            this.tryLock = tryLock;
        }

        public void run() {
            try {
                tryLock.performLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class TryLock {
        private Lock lock = new ReentrantLock();

        public void performLock() throws InterruptedException {
            lock.lock();
            try {
                // critical section
                System.out.println("Lock acquired by " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } finally {
                lock.unlock();
            }
        }
    }
}
