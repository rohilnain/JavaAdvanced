package Multithreading;

import java.math.BigInteger;

public class FactorialDemo {
    private BigInteger fac;
    private Integer mod=1000000007;
    FactorialDemo(){
        fac=BigInteger.ONE;
    }
    public BigInteger calculateFactorial(Integer num){
        for(int i=1;i<=num;i++) {
            fac=fac.multiply(BigInteger.valueOf(i));
        }
        //System.out.println("Inside feactorial demo class current thread is: "+Thread.currentThread().getName());
        return fac;
    }
}
