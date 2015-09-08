package com.Callum.Practice;

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
}
