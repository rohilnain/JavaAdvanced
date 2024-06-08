package Multithreading;

import java.math.BigInteger;

public class FactorialRunnable implements Runnable{
    private Integer val;
    private BigInteger fac;
    public FactorialRunnable(Integer val){
        this.val=val;
        fac=BigInteger.ONE;
    }
    @Override
    public void run() {
        for(int i=1;i<=val;i++){
            fac=fac.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Inside factorial Runnable and Thread name is: "+Thread.currentThread().getName());
        System.out.println("factorial value is: "+fac);
    }
    public BigInteger getFactorial(){
        return fac;
    }
}
