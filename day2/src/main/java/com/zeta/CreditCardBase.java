package com.zeta;

public abstract class CreditCardBase {
    private float dueAmount;
    private int number;
    private String name;

    public CreditCardBase(String customerName){
        this.name=customerName;;
    }

    public float getDueAmount(){
        return dueAmount;
    }

    public void setDueAmount(float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public int getNumber() {
        return number;
    }

    public String getName(){
        return name;
    }


}
