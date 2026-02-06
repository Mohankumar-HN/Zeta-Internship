package Executor;

import com.zeta.BankAccount;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        BankAccount account=new BankAccount(1000);
        Future future=executorService.submit(new DepositTask(account,1000));
        Future future1=executorService.submit(new DepositTask(account,1000));
        System.out.println(future.get());
        System.out.println(future1.get());
        System.out.println(account.getBalance());
        executorService.shutdown();
    }
}
