package com.icap.mywork;

import com.icap.mywork.PrimeNumberService;
import
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 * Created by ssingh358 on 27/04/2016.
 */
public class PrimeNumberWebApp {


    private static PrimeNumberService primeNumberService = new PrimeNumberService();
    @GET
    @Path("{number}")
    public String isPrimeNumber(@PathParam("number") int number) {
        this.number = number;
        //fixed pool size of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Boolean> futureOne = executor.submit(new MyThread1(primeNumberService.checkPrime8(number)));
        Runnable jobTwo = new  MyThread(primeNumberService.checkPrime8(number));
        jobTwo.run();
        bSuccessfulOne = futureOne.get();

        System.out.println("Check prime number for " + number );
        Boolean result8 = primeNumberService.checkPrime8(number);
        if(result8)
        //if(result)
            return number + " is a prime number";
        else
            return number + " is not prime number";
    }

}
