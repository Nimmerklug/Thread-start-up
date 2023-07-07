package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock2 {
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
                tryLock.performTryLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class TryLock {
        private Lock lock = new ReentrantLock();

        public void performTryLock() throws InterruptedException {
            boolean isLockAcquired = lock.tryLock();
            if (isLockAcquired) {
                // critical section
                System.out.println("Lock acquired by " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Lock to be unlocked by " + Thread.currentThread().getName());
                lock.unlock();
            } else {
                System.out.println("Lock could not be acquired by " + Thread.currentThread().getName());
            }
            System.out.println("Run by " + Thread.currentThread().getName());
        }
    }
}
