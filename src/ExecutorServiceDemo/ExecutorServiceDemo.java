package ExecutorServiceDemo;

import Multithreading.FactorialRunnable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> input2 = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000 ,7000 ,8000 ,9000 ,10000);

        //Lets Implement Executor Service using FixedThreadPool
        //here core poll size is n threads maximum is also nthreads
        //keep alive time 0
        //and queue is blocking system queue
        ExecutorService ex1=Executors.newFixedThreadPool(4);

        //lets use it
        long startTime=System.currentTimeMillis();
        input2.forEach((Integer val)->{
            FactorialRunnable fr=new FactorialRunnable(val);
            ex1.submit(fr);
        });
        //after using service let shut it down
        //it will not accept any new tasks wait for previous task to finish
        ex1.shutdown();

        ex1.awaitTermination(12,TimeUnit.MINUTES);//next statement  will not work because we need to wait for execution of all threads
        long endTime=System.currentTimeMillis();

        System.out.println("Time taken by fixed thread pool executor " + (endTime-startTime));


        //now lets see other one single ThreadExecutor

        //An executor that uses a single worker thread operating off an
        // unbounded queue (LinkedBlockingQueue).  Useful when you need to ensure that tasks are executed
        // sequentially and no more than one task is active at any given time.
        ExecutorService ex2=Executors.newSingleThreadExecutor();

        startTime=System.currentTimeMillis();
        input2.forEach((Integer val)->{
            FactorialRunnable fr=new FactorialRunnable(val);
            ex2.submit(fr);
        });

        //after using service let shut it down
        //it will not accept any new tasks wait for previous task to finish
        ex2.shutdown();

        //awaitTermination to be called after shutdown
        //It waits for min(all task to finish,time given) then it moves to next line
        try {
            if (!ex2.awaitTermination(12, TimeUnit.MINUTES)) {
                ex2.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex2.shutdownNow();
            Thread.currentThread().interrupt();
        }

        endTime=System.currentTimeMillis();
        System.out.println("Time taken by single thread pool executor " + (endTime-startTime));

        //now lets see dynamic thread executor service cached Thread Executor service
        ExecutorService ex3=Executors.newCachedThreadPool();
        //core pool size :0 , maxPool Size: Integer.MAX_VALUE
        //Keep alive Time: 60 seconds
        //SynchronousQueue: A blocking queue in which each insert operation must wait for a
        // corresponding remove operation by another thread, and vice versa.
        // A synchronous queue does not have any internal capacity, not even a capacity of one
        //Ideal for applications that launch many short-lived tasks.
        startTime=System.currentTimeMillis();
        input2.forEach((Integer val)->{
            FactorialRunnable fr=new FactorialRunnable(val);
            ex3.submit(fr);
        });

        //after using service let shut it down
        //it will not accept any new tasks wait for previous task to finish
        ex3.shutdown();

        //awaitTermination to be called after shutdown
        //It waits for min(all task to finish,time given) then it moves to next line
        try {
            if (!ex3.awaitTermination(12, TimeUnit.MINUTES)) {
                ex3.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex3.shutdownNow();
            Thread.currentThread().interrupt();
        }

        endTime=System.currentTimeMillis();
        System.out.println("Time taken by Cached thread pool executor " + (endTime-startTime));

        //new lets see Scheduled Thread Executor Service
        //it is polymorphed into ScheduledExecutorService
        ScheduledExecutorService ex4=Executors.newScheduledThreadPool(4);

        //corePoolSize, Integer.MAX_VALUE,
        //DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,
        //DelayedWorkQueue());

        ScheduledExecutorService ex5=Executors.newSingleThreadScheduledExecutor();

        //works best when you want to start certain task after a time period
        //or recurrent tasks
        startTime=System.currentTimeMillis();
        input2.forEach((Integer val)->{
            FactorialRunnable fr=new FactorialRunnable(val);
            ex4.schedule(fr, 1, TimeUnit.SECONDS);

//            ex4.scheduleAtFixedRate(() -> {
//                System.out.println("Periodic task executed by scheduledThreadPool");
//            }, 1, 3, TimeUnit.SECONDS);
        });

        //after using service let shut it down
        //it will not accept any new tasks wait for previous task to finish
        ex4.shutdown();

        //awaitTermination to be called after shutdown
        //It waits for min(all task to finish,time given) then it moves to next line
        try {
            if (!ex4.awaitTermination(12, TimeUnit.MINUTES)) {
                ex4.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex4.shutdownNow();
            Thread.currentThread().interrupt();
        }

        endTime=System.currentTimeMillis();
        System.out.println("Time taken by Scheduled thread pool executor " + (endTime-startTime));



    }
}
