package Daemons;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonRunner());
        t1.setDaemon(true);

        Thread t2 = new Thread(new WorkerRunner());

        t1.start();
        t2.start();

        //DaemonRunner is interrupted by JVM when all workers thread finish execution
    }
}
