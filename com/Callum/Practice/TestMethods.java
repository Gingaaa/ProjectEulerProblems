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

        long x = 12345678987654321L, y = 12345, z = 9022309;

        System.out.println(helperMethods.isPalindrome(x));
        System.out.println(helperMethods.isPalindrome(y));
        System.out.println(helperMethods.isPalindrome(z));

    }
}
