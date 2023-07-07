package ThreadClassMethods;

public class MainSleep {
        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Current thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt(); /* this line will keep Thread.interrupted() returns true */
                        throw new RuntimeException(e);
                    }
                    System.out.println("Current thread: " + Thread.currentThread().getName());
                }
            }, "CB-Thread");

            System.out.println("Current th: " + Thread.currentThread().getName());
            thread.start();
            System.out.println("Current th: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Current th: " + Thread.currentThread().getName());
        }
}
