package MultithreadingIssues;

import java.util.concurrent.atomic.AtomicInteger;

public class LibraryCountTask implements Runnable {

    //private int count;
    private AtomicInteger count;

    private Object lock = new Object();

    public LibraryCountTask() {
        //count = 0;
        count = new AtomicInteger(0);
    }

    public int getCount() {
        //return count;
        return count.get();
    }

    @Override
    public void run() {
        incrementCount3();
    }

    // Issues because of multithreading
    private  void incrementCount() {
        //count++;
    }

    //solution 1 make whole function synchronised so that
    //one thread can access the resource at a time

    private synchronized void incrementCount1(){
        //count++;
    }

    //solution 2: better than previous make critical resource  synchronised so that
    //one thread can access the resource at a time
    private void incrementCount2() {
        synchronized (lock) {
           // count++;
        }
    }

    //third approach make integer atomic
    //so operation on that can be atomic
    //no two operation at same time
    private void incrementCount3() {
        count.addAndGet(1);
    }


}
