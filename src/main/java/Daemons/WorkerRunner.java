package Daemons;

public class WorkerRunner implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("!!! Worker Runner Thread finished his execution ...");
    }
}
