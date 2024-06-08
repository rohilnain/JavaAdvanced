package MultithreadingIssues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        //Issues with multithreading
        //1st Race condition
        ExecutorService ex = Executors.newFixedThreadPool(4);

        LibraryCountTask task = new LibraryCountTask();

        for(int i=0; i<2000000; i++) {
            ex.submit(task);
        }

        ex.shutdown();
        ex.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("Total no. of people in the library" +
                " are: "+ task.getCount());

        //2nd memory Inconsistency Issue
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new MemoryInconsistencyIssue.Writer());
        executor.submit(new MemoryInconsistencyIssue.Reader());

        executor.shutdown();
    }
}