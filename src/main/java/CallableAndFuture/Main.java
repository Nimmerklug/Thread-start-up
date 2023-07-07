package CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        //anonymous call of Callable
        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            //return value is Integer
            public Integer call() throws TimeoutException {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new TimeoutException("Sleeping for too long.");
                }

                System.out.println("Starting ...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); /* this line will keep Thread.interrupted() returns true */
                    throw new RuntimeException(e);
                }
                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        try {
            //get returned value from call()
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            //TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(e.getMessage());
        }
    }

}

