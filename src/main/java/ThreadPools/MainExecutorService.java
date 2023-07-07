package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorService {
    public static void main(String[] args) {
        // returns instance of "ThreadPoolExecutor" class
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //xecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));

        executorService.shutdown();
    }
}
