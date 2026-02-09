package com.zeta.list;



import javax.naming.InsufficientResourcesException;

public class SavingsAccount extends AccountLambda{

    public SavingsAccount(int number) {
        super(number);
    }

    @Override
    public float deposit(float amount) {
        return 0;
    }


}

