package Challenges.Test32;

import java.util.ArrayList;
import java.util.List;

class ProducerAndConsumer {
    private List<Integer> list = new ArrayList<>();
    private int loopCount;
    private int listSize;

    private Object lock = new Object();

    public ProducerAndConsumer(int loopCount, int listSize) {
        if(loopCount <1){
            loopCount=1;
        }
        if(listSize<1){
            listSize=1;
        }
        this.loopCount = loopCount;
        this.listSize = listSize;
    }

    void fillList() throws InterruptedException { //produce
        int i=0;
        synchronized(lock) { //  synchronized(this)
            while(i++ < loopCount) {
                if (list.size() == listSize) {
                    System.out.println(Thread.currentThread().getName() + " : waiting for list items to be consumed...");
                    lock.wait();
                } else {
                    System.out.println(Thread.currentThread().getName() + " : Add |"+list.size()+"| to the list:"+list);
                    list.add(list.size());
                    lock.notify();// will notify immediately, it will continue to do while stuff
                    System.out.println(Thread.currentThread().getName() + " : notify...");
                }
                System.out.println(Thread.currentThread().getName() + " : list "+list+" at the end of LoopCount="+i);
                Thread.sleep(500);
            }
        }
    }

    void emptyList() throws InterruptedException { //consume
        int i=0;
        synchronized(lock) { //  synchronized(this)
            while(i++ < loopCount) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " : waiting for list items to be consumed...");
                    lock.wait();
                } else {
                    System.out.println(Thread.currentThread().getName() + " : Remove from the list:"+list+" - |"+list.remove(list.size()-1)+"|");
                    lock.notify();// will notify immediately, it will continue to do while stuff
                    System.out.println(Thread.currentThread().getName() + " : notify...");
                }
                System.out.println(Thread.currentThread().getName() + " : list "+list+" at the end of LoopCount="+i);
                Thread.sleep(500);
            }
        }
    }
}

