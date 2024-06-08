package Multithreading;

public class TaskUsingRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Implementing Task using Runnable: Multithreading " +Thread.currentThread().getName());
    }
}
