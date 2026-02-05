package com.zeta.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Worker");
    }
}

public class ExecuterServiceDemo {
    public  static void main(String[] args){
        ExecutorService executor= Executors.newSingleThreadExecutor();
        executor.submit(new Worker2());
        executor.shutdown();
    }
}
