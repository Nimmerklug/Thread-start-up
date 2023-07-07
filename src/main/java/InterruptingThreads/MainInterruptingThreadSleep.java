package InterruptingThreads;

public class MainInterruptingThreadSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("The thread is interrupted !!!");
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}
