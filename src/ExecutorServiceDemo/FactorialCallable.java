package ExecutorServiceDemo;

import Multithreading.FactorialRunnable;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialCallable implements Callable {
    private BigInteger fac;
    private Integer num;
    public FactorialCallable(Integer num){
        this.num=num;
        fac=BigInteger.ONE;
    }
    @Override
    public BigInteger call() throws Exception {
        for(int i=1;i<=num;i++){
            fac=fac.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Inside factorial callable. Thread is "+ Thread.currentThread().getName());
        return fac;
    }
}
