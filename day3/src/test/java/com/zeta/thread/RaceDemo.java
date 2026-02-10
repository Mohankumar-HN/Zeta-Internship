package com.zeta.thread;

public class RaceDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread t1=new Worker1(counter);
        t1.start();
//        System.out.println(counter.getValue());
        Thread t2=new Worker1(counter);
        t2.start();
        t1.join();
        t2.join();
//        System.out.println(counter.getValue());
        System.out.println(counter.getValue());
    }
}
