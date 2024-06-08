package Multithreading;

import java.math.BigInteger;
import java.sql.Time;

public class Client {
    public static void main(String[] args) {
       FactorialDemo fd=new FactorialDemo();
       long start=System.currentTimeMillis();
       BigInteger ans=fd.calculateFactorial(1259);
       System.out.println(ans);
       long end=System.currentTimeMillis();
       System.out.println(end-start);
       System.out.println(Thread.currentThread().getName());

       //implementing new thread using runnable;
        TaskUsingRunnable tr=new TaskUsingRunnable();
        Thread th=new Thread(tr);
        th.start();
        System.out.println(Thread.currentThread().getName());

        //or like this using Anonymous class for Runnable
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Implementing task using runnable anonymous class : Multithreading "+Thread.currentThread().getName());
            }
        });

        th2.start();

        //or like this using Lambda expression for implementing runnable functional interface
        Thread th3=new Thread(()->{
            System.out.println("Implementing task using runnable Lambda Expression class : Multithreading "+Thread.currentThread().getName());
        });

        th3.start();


        //Now creating new thread using thread class

        Thread th4=new Thread();
        th4.start(); //this can be done but it will override run method which does has not have anything

        //Creating new thread using Thread class
        Thread th5=new TaskUsingThread();
        th5.start();
    }
}
