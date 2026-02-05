package com.zeta.thread;

public class Counter {
    int count=0;
    void increment(){
        System.out.println("inside"+count);
        synchronized (this){
            for(;;)
                count++;
        }
    }

    synchronized  int getValue() {
        return count;
    }
}

class Worker1 extends Thread{
    private final Counter counter;
    public Worker1(Counter counter){
        this.counter=counter;
    }
    @Override
    public void run(){
        counter.increment();
    }
}
