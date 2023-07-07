package LockObjects;

public class Main {

/*
1) Locks can be implemented across the methods, you can invoke lock() in one method and invoke unlock() in another method. A synchronized block is fully contained within a method.

2) A thread gets blocked if it can't get access to the synchronized block. On the other hand, the trylock(timeout) method in the Lock framework will get the lock on the resource if it is available; otherwise, it returns false and the thread won't get blocked.

3) Fairness management is not possible with synchronized blocks. We can achieve fairness within the Lock APIs by specifying the fairness property.

4) A list of waiting threads cannot be seen with the synchronized keyword. A list of waiting threads can be seen using the Lock framework.

5) The unlock() method of a lock cannot be executed if the method throws an exception. Synchronization works clearly in this case. It releases the lock.
 */

    public static void main(String[] args) {
        System.out.println("Synchronized Objects: ");
        Worker worker = new Worker();
        worker.main();
        System.out.println("Synchronized Methods: ");
        WorkerMethodsSynchronized worker2 = new WorkerMethodsSynchronized();
        worker2.main();
    }
}
