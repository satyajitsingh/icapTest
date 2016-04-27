package com.icap.mywork;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by ssingh358 on 27/04/2016.
 */
public class PrimeNumberService implements Runnable  {

    Integer input;

    //second algorithm
    public Boolean checkPrime(Integer input) {
        if (input%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=input;i+=2) {
            if(input%i==0)
                return false;
        }
        return true;
    }

    public Boolean checkPrime8(Integer input) {
        IntPredicate isDivisible = index -> input % index == 0;
        return input > 1
                && IntStream.range(2, input).noneMatch(
                isDivisible);
    }

    @Override
    public void run()
    {
        try
        {
            Long duration = (long) (Math.random() * 10);
            System.out.println("computing Prime for : " + input);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
