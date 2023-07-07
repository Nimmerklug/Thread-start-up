package ThreadPools;

import java.util.concurrent.*;

class AreaCalculator {
    private ExecutorService executor
            = Executors.newFixedThreadPool(3);

    public Future<Integer> calculate(int length, int width) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return length * width;
        });
    }

    public void shutdown() {
        this.executor.shutdown();
    }
}
public class MainFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        AreaCalculator areaCalculator = new AreaCalculator();
        Future<Integer> areaFutureA = areaCalculator.calculate(10, 20);
        Future<Integer> areaFutureB = areaCalculator.calculate(15, 25);

        while (!areaFutureA.isDone() || !areaFutureB.isDone()) {
            System.out.println(
                    String.format(
                            "areaFutureA calculation is %s and areaFutureB calculation is %s",
                            areaFutureA.isDone() ? "done !!!" : "running ...",
                            areaFutureB.isDone() ? "done !!!" : "running ..."
                    )
            );
            Thread.sleep(300);
        }

        Integer areaA = areaFutureA.get(1500, TimeUnit.MILLISECONDS);
        Integer areaB = areaFutureB.get(1500, TimeUnit.MILLISECONDS);
        System.out.println("AreaA: " + areaA + ", AreaB: " + areaB);
        System.out.println("Calculation is complete !!!");
        areaCalculator.shutdown();
    }
}
