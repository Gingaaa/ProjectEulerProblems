package com.Callum.Practice;

public class Main {

    public static void main(String[] args) {
        Main run = new Main();
	    //System.out.print(run.Problem1());
	    System.out.print(run.Problem2());

    }

    private long Problem1(){
        long sum=0, target=1000;
        for(int i=0;i<target;i++){
            if(i%3==0||i%5==0)
                sum=sum+i;
        }
        return sum;
    }
    private long Problem2(){
        long sum=0, target=4000000, x=0, y=1, result=0;
        while(y<target){ //y is larger value so will exceed target first
            result=x+y;
            if(result%2==0)
                sum=sum+result;
            x=y;
            y=result;
        }
        return sum;
    }


}

