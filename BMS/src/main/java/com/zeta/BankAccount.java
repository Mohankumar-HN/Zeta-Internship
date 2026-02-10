package com.zeta;

public class BankAccount {
    private int balance;
    private int accountID;
    Loan loan;

    private static final float monthlyInterest=3.0f;

    public BankAccount(int balance,int accountID){

        this.balance=balance;
        this.accountID=accountID;
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
        if (amount <= 0) {
            throw new IllegalArgumentException("enter a positive value");
        }
    }


    public synchronized  boolean availLoan(int loanAmount,  int tenure) {
        validateAmount(loanAmount);
//        Validator validator = (a) -> {
//            if (a < 0) {
//                throw new IllegalArgumentException("enter a positive value");
//            }};
        if (loan != null) {
            System.out.println("Loan already exists");
            return false;
        }
        if (balance < 1000000) {
            System.out.println("Balance should be at least 1 lakh to avail loan");
            return false;
        }
        this.loan = new Loan( monthlyInterest,loanAmount, tenure);
        System.out.println("loan approved");
        return true;
    }

    public synchronized boolean hasLoan() {

        return loan != null;
    }


    public synchronized void checkLoanStatus(){
        if(loan==null){
            System.out.println("No active loan");
            return;
        }
        System.out.println("Loan Details");
        System.out.println("Loan taken: "+loan.amount);
        System.out.println("Interest rate: "+loan.interest);
        System.out.println("Tenure: "+loan.tenure);
    }

    public int getAccountId() {
        return accountID;
    }
}
