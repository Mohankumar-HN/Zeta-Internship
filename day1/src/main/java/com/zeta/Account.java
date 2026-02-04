package com.zeta;

public abstract class Account {
    private float balance;
    private final int number;
    private ACCOUNT_TYPE type;



    public abstract float deposit (float amount);
    public abstract float withdraw (float amount) throws InsufficientBalanceException;

    public int getNumber() {
        return number;
    }

    public ACCOUNT_TYPE getType() {
        return type;
    }

    public void setType(ACCOUNT_TYPE type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Account(int number) {
        this.number = number;
    }

}