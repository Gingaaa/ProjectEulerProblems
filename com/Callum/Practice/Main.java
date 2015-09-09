package com.Callum.Practice;

import java.util.ArrayList;

public class Main
{
    HelperMethods helperMethods = new HelperMethods();

    public static void main(String[] args)
    {
        Main run = new Main();
	    /*
	    System.out.print(run.problem1());
	    System.out.print(run.problem2());
	    System.out.print(run.problem3());
	    System.out.print(run.problem4());
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
            //noinspection SuspiciousNameCombination
            x=y;
            y=result;
        }
        return sum;
    }
    private long problem3() //find the prime factors of the target
    {
        long target=600851475143L;
        ArrayList<Long> primeFactors = new ArrayList<Long>(helperMethods.primeFactors(target));
        return primeFactors.get(primeFactors.size()-1); //return the last item in the list which should be the largest
    }
    private long problem4() //find the largest palindrom made from 2 3 digit numbers. Brute force method
    {
        int highest=0, iHigh=0, jHigh=0;

        for(int i=999; i>99; i--)
        {
            for(int j=i; j>99; j--)
            {
                if(i*j <= highest)  //stops checking numbers if it's impossible to be higher than current highest palindrome
                    break;
                if(helperMethods.isPalindrome(i*j))
                {
                    if(i*j > highest)
                    {
                        highest = i*j;
                        iHigh = i;
                        jHigh = j;
                    }
                }
            }
        }
        //System.out.println(iHigh + " * " + jHigh); //Just wanted to check what the factors were, not needed for answer however
        return highest;
    }

}

