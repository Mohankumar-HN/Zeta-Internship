package com.zeta.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker("staff");
        Worker worker1=new Worker("manager");
        worker.start();;
        worker.join();
        try{
            worker.wait(3000);
        }catch(Exception e){

        }
        worker1.start();
    }
}
