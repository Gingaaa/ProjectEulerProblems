package com.Callum.Practice;

import java.util.ArrayList;

/**
 * Created by Callum on 6/09/2015.
 *
 * Methods to help solve the problems which may be useful again
 */
public class HelperMethods
{
    protected boolean isPrime(long n)
    {
        if(n%2==0)
            return false;
        for(int i=3; i*i<=n; i+=2)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    protected long nextPrime(long cur)
    {
        if(cur == 2)
            return 3;
        long next = cur+2;
        while(!isPrime(next))
            next += 2;
        return next;
    }
    protected ArrayList<Long> primeFactors(long target) //find the prime factors of the target
    {
        long curPrime=2;
        ArrayList<Long> primeFactors = new ArrayList<Long>();
        while(!isPrime(target)) //If the target is a prime, it is the final and largest prime factor
        {
            if(target%curPrime == 0) //if the target divides evenly then that prime is a prime factor, so start again
            {
                primeFactors.add(curPrime);
                target = target / curPrime;
                curPrime=2;
            }
            else{ //otherwise move onto the next prime number
                curPrime=nextPrime(curPrime);
            }
        }
        primeFactors.add(target); //the target is now the last prime factor so add to end of array
        return primeFactors;
    }

    protected boolean isPalindrome(long n)
    {
        String nAsString = Long.toString(n);
        int i=0, j=nAsString.length()-1; //the first and last positions of the palindrome in the string array
        while(i<=j) //Deals with even and odd length palindromes
        {
            if(nAsString.substring(i,i+1).equals(nAsString.substring(j,j+1)))
            {
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }

    protected long gcd(long a, long b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    protected long lcm(long a, long b)
    {
        return (a*b)/gcd(a,b);
    }


}
