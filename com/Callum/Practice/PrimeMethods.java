package com.Callum.Practice;

/**
 * Created by Callum on 6/09/2015.
 */
public class PrimeMethods
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
}
