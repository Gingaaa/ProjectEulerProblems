package com.Callum.Practice;

import com.Callum.Practice.PrimeMethods;

public class Main {

    public static void main(String[] args)
    {
        Main run = new Main();
	    /*
	    System.out.print(run.problem1());
	    System.out.print(run.problem2());
	     */
        System.out.print(run.problem3());




    }

    private long problem1(){
        long sum=0, target=1000;
        for(int i=0;i<target;i++)
        {
            if(i%3==0||i%5==0)
                sum=sum+i;
        }
        return sum;
    }
    private long problem2()
    {
        long sum=0, target=4000000, x=0, y=1, result;
        while(y<target)//y is larger value so will exceed target first
        {
            result=x+y;
            if(result%2==0)
                sum=sum+result;
            x=y;
            y=result;
        }
        return sum;
    }
    private long problem3() //find the prime factors of the target
    {
        long target=600851475143L, curPrime=2;
        PrimeMethods primeMethods = new PrimeMethods();

        while(!primeMethods.isPrime(target)) //If the target is a prime, it is the final and largest prime factor
        {
            if(target%curPrime == 0) //if the target divides evenly then that prime is a prime factor, so start again
            {
                target = target / curPrime;
                curPrime=2;
            }
            else{ //otherwise move onto the next prime number
                curPrime=primeMethods.nextPrime(curPrime);
            }
        }
        return target;

    }


}

