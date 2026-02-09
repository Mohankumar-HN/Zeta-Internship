package com.zeta;

import jdk.jfr.Threshold;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer>{
    private static final int Threshold=3;
    private int[] arr;
    private int start,end;

    SumTask(int[] arr,int start,int end){
        this.arr=arr;
        this.start=start;
        this.end=end;
    }


    @Override
    protected Integer compute() {
        if(end-start<=Threshold){
            int sum=0;
            for(int i=start;i<end;i++){
                sum+=arr[i];
            }
            return sum;
        }else{
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            left.fork();
            int Rightresult=right.compute();
            int leftresult=left.join();
            return leftresult+Rightresult;
        }

    }
}


public class ForkJoin {
    public static void main(String[] args){
        int[] data={10,20,3,4,5,6,7,8,9,2,3};
        ForkJoinPool pool=new ForkJoinPool();
        int result=pool.invoke(new SumTask(data,0,data.length));
        System.out.println("sum "+result);
    }
}
