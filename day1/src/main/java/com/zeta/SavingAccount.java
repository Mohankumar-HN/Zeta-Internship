package com.zeta;

import javax.naming.InsufficientResourcesException;

public class SavingAccount extends Account{

    public SavingAccount(int i) {
        super(i);
    }

    @Override
    public float deposit(float amount) {
        this.setBalance(this.getBalance()+amount);
        return this.getBalance();
    }

    @Override
    public float withdraw(float amount) throws InsufficientBalanceException {
        if(amount<=0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if(this.getBalance()<amount){
            throw new InsufficientBalanceException("Current Balance "+this.getBalance());
        }else{
            this.setBalance(this.getBalance()-amount);
            return this.getBalance();
        }
    }
}
