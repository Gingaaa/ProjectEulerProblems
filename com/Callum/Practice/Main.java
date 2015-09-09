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
        System.out.println(run.problem6());
    }
    private long problem1()
    {
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
    private long problem4() //find the largest palindrome made from 2 3 digit numbers. Brute force method
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
    private long problem5() //find the least common multiplier of all integers up to 20
    {
        long a=380,b=340,c=260,d=220,e=180,f=140,g=80; //Check book of problem solving to find out how I got these numbers, basically all other factors can reduce to these 20*(19,17,13,11,9,7,4)
        return helperMethods.lcm(a,helperMethods.lcm(b,helperMethods.lcm(c,helperMethods.lcm(d,helperMethods.lcm(e,helperMethods.lcm(f,g))))));
    }
    private long problem5b() //brute force, 115 times slower than other method
    {
        long n=20;
        while(true)
        {
            if(n%19 == 0 && n%18 == 0 && n%17 == 0 && n%16 == 0 && n%14 == 0 && n%13 == 0 && n%12 == 0 && n%11 == 0 && n%9 == 0 && n%8 == 0 && n%7 == 0 && n%6 == 0 && n%4 == 0 && n%3 == 0)
                return n;
            else{
                n+=20;
            }
        }
    }
    private long problem6()  //Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
    {
        long sumSquares=0, squareSum=0;

        for(int i=1; i<101; i++)
        {
            sumSquares += i*i;
            squareSum = squareSum + i;
        }
        squareSum = squareSum * squareSum;
        return squareSum - sumSquares;
    }
}

