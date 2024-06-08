package Multithreading;
public class TaskUsingThread extends Thread {

    @Override
    public void run(){
        System.out.println("Creating new thread using thread class: Multithreading "+Thread.currentThread().getName());
    }
}
