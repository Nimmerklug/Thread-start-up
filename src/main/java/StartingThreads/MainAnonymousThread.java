package StartingThreads;

public class MainAnonymousThread {
    public static void main(String[] args) {
        Thread th = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread started");
            }
        };
        th.start();
    }
}
