package StartingThreads;

public class MainAnonymousRunnableLambda {
        public static void main(String[] args) {
            Thread th = new Thread(() -> System.out.println("Thread started"));
            th.start();
        }
    }
