package Challenges.Test33;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition(); // allow to use wait() and notify()

    void fillList() throws InterruptedException { //produce
        System.out.println(Thread.currentThread().getName() + " : lock produce method");
        lock.lock();

        System.out.println(Thread.currentThread().getName() + " : await produce method");
        condition.await(); //wait()

        System.out.println(Thread.currentThread().getName() + " : unlock produce method");
        lock.unlock();
    }

    void emptyList() throws InterruptedException { //consume
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " : lock consume method");
        lock.lock();

        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " : signal consume method");
        condition.signal(); //notify()

        System.out.println(Thread.currentThread().getName() + " : unlock consume method"); 
        lock.unlock();
    }
}
