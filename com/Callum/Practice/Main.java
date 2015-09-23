package com.Callum.Practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
    HelperMethods helperMethods = new HelperMethods();

    public static void main(String[] args)
    {
        Main run = new Main();
        long start, startNs;
	    /*
	    System.out.print(run.problem1());
	    System.out.print(run.problem2());
	    System.out.print(run.problem3());
	    System.out.print(run.problem4());
	    System.out.print(run.problem5());
	    System.out.print(run.problem6());
	    System.out.print(run.problem7());
	    System.out.print(run.problem8());
	    System.out.print(run.problem9());
	    System.out.print(run.problem10());
	    System.out.print(run.problem11());
	    System.out.print(run.problem12());
	    System.out.print(run.problem13());
	     */
        start = System.currentTimeMillis();
        startNs = System.nanoTime();

        System.out.println(run.problem14());

        System.out.println("Completed in:");
        System.out.println(System.currentTimeMillis()-start+"ms");
        System.out.println(System.nanoTime()-startNs+"ns");
    }
    private long problem1()  //the sum of multiples of 3 or 5 below 1000
    {
        long sum=0, target=1000;
        for(int i=0;i<target;i++)
        {
            if(i%3==0||i%5==0)
                sum=sum+i;
        }
        return sum;
    }
    private long problem2()  //Sum the even fib sequence values under 4million
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
        ArrayList<Long> primeFactors = new ArrayList<>(helperMethods.primeFactors(target));
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
        //This is obviously not a reusable way to solve this problem
        long a=380,b=340,c=260,d=220,e=180,f=140,g=80; //Check book of problem solving to find out how I got these numbers, basically all other factors can reduce to these 20*(19,17,13,11,9,7,4)
        return helperMethods.lcm(a,helperMethods.lcm(b,helperMethods.lcm(c,helperMethods.lcm(d,helperMethods.lcm(e,helperMethods.lcm(f,g)))))); //Can make this into recursive method if needed again
    }
    private long problem5b() //brute force, 115 times slower than other method
    {
        long n=20;
        while(true)
        {
            if(n%19 == 0 && n%18 == 0 && n%17 == 0 && n%16 == 0 && n%14 == 0 && n%13 == 0 && n%12 == 0 && n%11 == 0 && n%9 == 0 && n%8 == 0 && n%7 == 0 && n%6 == 0 && n%4 == 0 && n%3 == 0)
                return n;
            else
                n+=20;
        }
    }
    private long problem6()  //Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
    { //brute force
        long sumSquares=0, squareSum=0;
        int target = 100;

        for(int i=1; i<=target; i++)
        {
            sumSquares += i*i;
            squareSum = squareSum + i;
        }
        squareSum = squareSum * squareSum;
        return squareSum - sumSquares;
    }
    private long problem7() //Find the 10001st prime
    {
        long curPrime=2;
        for(int i=0; i<10000; i++) //already found the first prime(2) so do 10000 more times
            curPrime = helperMethods.nextPrime(curPrime);
        return curPrime;
    }
    private long problem8()  //Find the largest product using adjacent numbers from a single large number
    {   //brute force
        long product=1, highestProduct=0; //Use product=1 to simplify for loop
        int reqDigits=13; //The number of adjacent digits to multiply
        char[] chars = StaticVariables.PROBLEM8NUM.toCharArray();
        int startIndex=0;

        int i=0;
        while(i+reqDigits <= chars.length)
        {
            for(int j=0;j<reqDigits;j++)
                product = product* Character.getNumericValue(chars[i+j]);
            if(product > highestProduct)
            {
                highestProduct = product;
                startIndex=i;
            }
            product=1;
            i++;
        }
        //System.out.println(StaticVariables.PROBLEM8NUM.substring(startIndex,startIndex + reqDigits)); //Prints the digits that make up highestProduct
        return highestProduct;
    }
    private long problem9()  //Find the pythagorean  triplet where a+b+c=1000
    {
        int sum=1000;
        for(int a=1; a<=sum/3; a++)
            for(int b=a+1;b<(sum-b-a);b++)
                if((a*a)+(b*b) == ((sum-b-a)*(sum-b-a)))
                    return a*b*(sum-b-a);
        return 0;
    }
    private long problem10()  //Sum all primes below 2million
    {
        int target=2000000;
        long sum=0, curPrime=2;

        while(curPrime<target)
        {
            sum+=curPrime;
            curPrime = helperMethods.nextPrime(curPrime);
        }
        return sum;
    }
    private long problem11()  //Find the largest product of 4 numbers in a 20x20 2digit grid in any direction
    {
        String num = StaticVariables.PROBLEM11NUM.replaceAll("\\s",""); //removes the spaces in the number for simpler processing
        int[][] numArray = new int[20][20];
        int index=0,rows=20,maxSum=0;

        for(int i=0;i<rows;i++)  //Puts the subsequent 2 digits from the large num into the 2d array
            for(int j=0;j<rows;j++)
            {
                numArray[i][j]=Integer.parseInt(num.substring(index,index+2));
                index+=2;
            }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<rows;j++)
            {   //2 ways I can do this, try catch for every check, or one try catch but with more complex code (while loop and switch block) to check every direction
                //Initially use multiple try catches to make sure code actually works first
                try
                {   //check upDiag
                    if((numArray[i][j]*numArray[i-1][j+1]*numArray[i-2][j+2]*numArray[i-3][j+3]) > maxSum)
                        maxSum = (numArray[i][j]*numArray[i-1][j+1]*numArray[i-2][j+2]*numArray[i-3][j+3]);
                }catch(ArrayIndexOutOfBoundsException e){}  //Just ignore this sum and carry on
                try
                {   //check right
                    if((numArray[i][j]*numArray[i][j+1]*numArray[i][j+2]*numArray[i][j+3]) > maxSum)
                        maxSum = (numArray[i][j]*numArray[i][j+1]*numArray[i][j+2]*numArray[i][j+3]);
                }catch(ArrayIndexOutOfBoundsException e){}  //Just ignore this sum and carry on
                try
                {   //check downDiag
                    if((numArray[i][j]*numArray[i+1][j+1]*numArray[i+2][j+2]*numArray[i+3][j+3]) > maxSum)
                        maxSum = (numArray[i][j]*numArray[i+1][j+1]*numArray[i+2][j+2]*numArray[i+3][j+3]);
                }catch(ArrayIndexOutOfBoundsException e){}  //Just ignore this sum and carry on
                try
                {   //check down
                    if((numArray[i][j]*numArray[i+1][j]*numArray[i+2][j]*numArray[i+3][j]) > maxSum)
                        maxSum = (numArray[i][j]*numArray[i+1][j]*numArray[i+2][j]*numArray[i+3][j]);
                }catch(ArrayIndexOutOfBoundsException e){}  //Just ignore this sum and carry on
            }
        }
        return maxSum;
    }
    private long problem12()  //Find the first triangle number that has over 500 factors
    {  //brute force. Another way would be to use prime factors.
       // Find prime factors of number, for each unique prime add 1 + the number of duplicates then multiply together. This equals the number of divisors for that number.
        long triangleSum=0, i=1;
        while(helperMethods.numFactors(triangleSum) <= 500)
        {
            triangleSum+=i;
            i++;
        }
        return triangleSum;
    }
    private BigInteger problem13()  //Find the first 10 digits of a large sum
    {  //This is the easiest way to solve. However it could be done without BigIntegers
        // Only the first 11 digits of each number need to be added as the 12th will never affect anything more than the 11th
        String num = StaticVariables.PROBLEM13NUM;
        int numLength=50, numOfNums=100, index=0;
        BigInteger result = new BigInteger("0");
        System.out.println(result);
        for(int i=0; i<numOfNums; i++)
        {
            result = result.add(new BigInteger(num.substring(index, index+numLength)));
            index+=numLength;
        }
        return result;
    }
    private int problem14()  //Find the longest Collatz sequence under 1million
    {   //Use of integer cache results in run time of ~20ms, faster than brute force ~200ms
        int count, maxCount=0, maxNum=0, target=1000000;
        long n;

        int[] cache = new int[target+1];
        for(int i=0; i<cache.length;i++)    //Initialise cache
            cache[i] = -1;
        cache[1]=0;

        for(int i=2; i<=target; i++)
        {
            count=0;
            n=i;
            while(n != 1 && n >= i) //The result of n will be in the cache if it is less than i
            {   //The Collatz logic
                count++;
                if(n%2 == 0)
                    n=n/2;
                else
                    n=n*3+1;
            }
            if(cache[(int)n] != -1)
                cache[i] = count + cache[(int) n]; //Store result in cache, adds the current to the previously calculated sequence count
            if(cache[i] > maxCount)
            {
                maxCount=cache[i];
                maxNum=i;
            }
        }
        return maxNum;
    }
}

