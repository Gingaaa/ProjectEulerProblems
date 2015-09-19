package com.Callum.Practice;

/**
 * Created by Callum on 6/09/2015.
 *
 * This is a class which will not contain any permanent code, I just use it
 * to quickly check the output of things I am not sure about
 */
public class TestMethods
{
    public static void main(String[] args)
    {
        HelperMethods helperMethods = new HelperMethods();
        TestMethods run = new TestMethods();
        int triangleSum=0, target=20;
        for(int i=1;i<=target;i++)
        {
            triangleSum+=i;
            System.out.println("Factors: " + triangleSum+": "+helperMethods.factors(triangleSum));
            System.out.println("PrimeFactors " + triangleSum+": "+helperMethods.primeFactors(triangleSum));
        }
    }
}
