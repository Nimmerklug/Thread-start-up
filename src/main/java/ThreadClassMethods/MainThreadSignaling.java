package ThreadClassMethods;

public class MainThreadSignaling {
    public static void main(String[] args) {
        Number number = new Number(10);

        Thread printEven = new PrintEven(number);
        printEven.setName("Print Even");
        printEven.start();

        Thread printOdd = new PrintOdd(number);
        printOdd.setName("Print Odd");
        printOdd.start();
    }

    private static class PrintEven extends Thread {
        private Number number;

        public PrintEven(Number number) {
            this.number = number;
        }

        public void run() {
            number.printEven();
        }
    }

    private static class PrintOdd extends Thread {
        private Number number;

        public PrintOdd(Number number) {
            this.number = number;
        }

        public void run() {
            number.printOdd();
        }
    }

    private static class Number {
        private int value = 1;
        private int n;

        public Number(int n) {
            this.n = n;
        }

        public synchronized void printEven() {
            while (value < n) {
                while (value % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + (value++));
                notify();
            }
        }

        public synchronized void printOdd() {
            while (value < n) {
                while (value % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + (value++));
                notify();
            }
        }
    }
}


/*public class MainThreadSignaling {
    private static class WaitNotify {
        private static MonitorObject monitorObject;
        boolean isSignalled = false;

        public WaitNotify(MonitorObject monitorObject) {
            this.monitorObject = monitorObject;
        }

        public void doWait() {
            synchronized (monitorObject) {
                if (!isSignalled) {
                    try {
                        monitorObject.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //clear signal
                isSignalled = false;
            }
        }

        public void doNotify() {
            synchronized (monitorObject) {
                isSignalled = true;
                monitorObject.notify();
            }
        }
    }

    private static class MonitorObject {
    }
}
 */
