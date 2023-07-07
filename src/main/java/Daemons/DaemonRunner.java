package Daemons;

public class DaemonRunner implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("| - Daemon Runner Thread is running ...");
        }
    }
}
