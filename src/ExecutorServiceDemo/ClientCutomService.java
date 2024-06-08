package ExecutorServiceDemo;

import Multithreading.FactorialRunnable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ClientCutomService {
    public static void main(String[] args) throws InterruptedException {
        CustomExecutorService customService=new CustomExecutorService(4,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2));

        List<Integer> input = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000 ,7000 ,8000 ,9000 ,10000);

        //lets use it
        long startTime=System.currentTimeMillis();
        input.forEach((Integer val)->{
            FactorialRunnable fr=new FactorialRunnable(val);
            customService.submit(fr);
        });
        //after using service let shut it down
        //it will not accept any new tasks wait for previous task to finish
        customService.shutdown();

        customService.awaitTermination(12,TimeUnit.MINUTES);//next statement  will not work because we need to wait for execution of all threads
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken by custom executor service " + (endTime-startTime));


        //lets see use of callable and future
        ExecutorService executor=Executors.newFixedThreadPool(4);

        // Create a list of Callable tasks
        List<Callable<BigInteger>> taskList = new ArrayList<>();
        taskList.add(new FactorialCallable(1000));
        taskList.add(new FactorialCallable(2000));
        taskList.add(new FactorialCallable(3000));
        taskList.add(new FactorialCallable(4000));
        taskList.add(new FactorialCallable(5000));

        try {
            // Submit tasks and store Future objects
            List<Future<BigInteger>> futures = executor.invokeAll(taskList);

            // Process the results
            for (Future<BigInteger> future : futures) {
                try {
                    System.out.println("Factorial result: " + future.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor
            executor.shutdown();
        }
    }

    }
