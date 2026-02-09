package com.zeta;

import com.zeta.exception.Validator;

class Withdrawtask implements Runnable {
    private final BankAccount account;
    private final int amount;

    public Withdrawtask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
//            account.validateAmount(amount);
        Validator validator = (a) -> {
            if (a < 0) {
                throw new IllegalArgumentException("enter a positive value");
            }};
            String thread = Thread.currentThread().getName();
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println(thread + "withdrawn amount  sussessfully :" + amount);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

    class DepositTask implements Runnable {
        private final BankAccount account;
        private final int amount;


        public DepositTask(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
//        account.validateAmount(amount);
            Validator validator = (a) -> {
                if (a < 0) {
                    throw new IllegalArgumentException("enter a positive value");
                }
            };
            String thread = Thread.currentThread().getName();
            account.deposit(amount);
            System.out.println(thread + "Depositing money...");
            System.out.println("Deposit completed \n Remaining balance : " + account.getBalance()
            );
        }

        ;
    }




