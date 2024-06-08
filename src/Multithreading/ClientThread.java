package Multithreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClientThread {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10);
        List<Integer> list = new ArrayList<>(Arrays.asList(1000, 1500, 2000, 2500, 3000));

        //lets see example of multithreading using stream and parallel Stream
        //Sometime stream can be efficient than parallel stream (as it outweighs overhead of parallel stream like mainting thread pool and all)
        //it is entirely dependent type of task and input (like for input for this system :stream will be efficient)
        // Using stream()
        long startTime = System.currentTimeMillis();
        List<BigInteger> ansStream = list.stream().map((Integer val) -> {
            FactorialDemo fd = new FactorialDemo();
            BigInteger fac = fd.calculateFactorial(val);
            System.out.println("Calculating Factorial in stream thread name: " + Thread.currentThread().getName());
            return fac;
        }).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken by stream(): " + (endTime - startTime) + " ms");

        // Using parallelStream()
        startTime = System.currentTimeMillis();
        List<BigInteger> ansParallelStream = list.parallelStream().map((Integer val) -> {
            FactorialDemo fd = new FactorialDemo();
            BigInteger fac = fd.calculateFactorial(val);
            System.out.println("Calculating Factorial in parallelStream thread name: " + Thread.currentThread().getName());
            return fac;
        }).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken by parallelStream(): " + (endTime - startTime) + " ms");

        System.out.println("Results from stream(): " + ansStream);
        System.out.println("Results from parallelStream(): " + ansParallelStream);

        // Get the runtime instance
        Runtime runtime = Runtime.getRuntime();
        // Get the number of available processors
        int availableProcessors = runtime.availableProcessors();
        // Print the number of available processors
        System.out.println("Number of available processors (cores): " + availableProcessors);

        //now lets see join method also and also impeleenting threads using runnable inteface

        List<Integer> input2 = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000 ,7000 ,8000 ,9000 ,10000);

        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i =0 ; i< 10; i++) {
            FactorialRunnable mt = new FactorialRunnable(input2.get(i));
            Thread th8 = new Thread(mt);
            th8.start();
            try{
                //join here is used so that until all threads are finished it should not go to
                //next line in main thread
                //kind of working like wait
                th8.join();
            }catch(Exception e){
                System.out.println("catching the exception: "+e);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time taken : " +(end-start));
        System.out.println("curent thread here is :"+ Thread.currentThread().getName());

        //or can be done by for each
        long startforEach=System.currentTimeMillis();
        input2.forEach((Integer val)->{
            FactorialRunnable mt = new FactorialRunnable(val);
            Thread th9 = new Thread(mt);
            th9.start();
            //it will lead to parralelism not concurrency because stream is there
            //always new thread
            //adding in threads list and then will iterate over it to join
            //so both of the method can be done
            threads.add(th9);

        });

        threads.forEach((Thread thread)->{
            try{
                thread.join();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long endforEach=System.currentTimeMillis();

        System.out.println("Time taken " + (endforEach-startforEach));
        System.out.println("curent thread here is :"+ Thread.currentThread().getName());


    }
}
