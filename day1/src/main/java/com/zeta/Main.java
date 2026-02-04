package com.zeta;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Account account = new SavingAccount(123);
        account.setType(ACCOUNT_TYPE.SAVINGS);

        System.out.println(account.getNumber());

        Account current = new CurrentAccount(999);
        current.setType(ACCOUNT_TYPE.CURRENT);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(current);

        accounts.forEach(account1 -> {
            account1.deposit(2000);
        });

        Bank bank = new Bank();

        Account savings = new SavingAccount(222);
        Account current1 = new CurrentAccount(888);


        savings.deposit(220);
        bank.transfer(savings, current1, 100);
        System.out.println("account2 balance:"+current1.getBalance());
    }
}
