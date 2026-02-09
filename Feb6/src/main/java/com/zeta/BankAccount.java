package com.zeta;

public class BankAccount {
    private int balance;
    Loan loan;

    public BankAccount(int balance){
        this.balance=balance;
    }

    public synchronized int getBalance(){
        return balance;
    }

    public synchronized boolean withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ "checking balance...");
        if(balance>=amount){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
            }
            balance-=amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount){
        System.out.println("Depositing amount...");
        try{
            Thread.sleep(500);;
        }catch(InterruptedException e){}
        balance+=amount;
    }

    void validateAmount(int amount){
        if(amount<0){
            throw new IllegalArgumentException("enter a positive value");
        }
    }

    public synchronized  boolean availLoan(int loanAmount, float interest, int tenure) {
        validateAmount(loanAmount);
        if (loan != null) {
            System.out.println("Loan already exists");
            return false;
        }
        this.loan = new Loan(interest, tenure, loanAmount);
        System.out.println("loan approved");
        return true;
    }
    public synchronized boolean hasLoan() {
        return loan != null;
    }

}
