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

        long x = helperMethods.gcd(380, 260);
        long y = helperMethods.lcm(260,220);
        System.out.println(x);
        System.out.println(y);

    }
}
