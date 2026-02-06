package Executor;

import com.zeta.BankAccount;

import java.util.concurrent.Callable;

public class DepositTask implements Callable {
    private final BankAccount account;
    private final int amount;

    public DepositTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep((long) Math.random() * 1000);
        String thread = Thread.currentThread().getName();
        System.out.println(thread + "depositing " + amount);
        account.deposit(amount);
        System.out.println(thread + "completed deposit of amount " + amount);
        return account.getBalance();
    }
}
