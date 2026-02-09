package com.zeta.list;



public abstract class AccountLambda {

    private final int number;

    public abstract float deposit (float amount);

    public int getNumber() {
        return number;
    }

    public AccountLambda(int number) {
        this.number = number;
    }

}
