package com.zeta;

public class CurrentAccount extends Account{
    public CurrentAccount(int number) {
        super(number);
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
