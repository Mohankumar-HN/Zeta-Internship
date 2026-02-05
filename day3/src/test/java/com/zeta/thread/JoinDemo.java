package com.zeta.thread;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Worker t=new Worker("staff-1");
        t.start();
        t.join();
        System.out.println("Main done");

        }

}
