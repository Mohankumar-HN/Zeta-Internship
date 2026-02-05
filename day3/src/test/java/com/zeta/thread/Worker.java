package com.zeta.thread;

public class Worker extends Thread{
    public Worker(String string) {
        super(string);
    }

    public void run(){
        for(int i=1;i<=5;i++) {
            try {
                System.out.println("thread is running  " + currentThread());
                Thread.sleep(2000);
                //throw new RuntimeException();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
