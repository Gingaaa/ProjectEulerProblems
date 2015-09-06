package com.Callum.Practice;

/**
 * Created by Callum on 6/09/2015.
 */
public class testMethods
{
    public static void main(String[] args)
    {
        PrimeMethods primeMethods = new PrimeMethods();
        long cur = 2;

        for(int i=1; i<=100; i++)
        {
            System.out.println(i + " " + cur);
            cur = primeMethods.nextPrime(cur);
        }
    }
}
