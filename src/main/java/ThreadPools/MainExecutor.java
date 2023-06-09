package ThreadPools;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> System.out.println(Thread.currentThread().getName()+" Hello A !!!"));
        executor.execute(()-> System.out.println(Thread.currentThread().getName()+" Hello B !!!"));
    }
}
