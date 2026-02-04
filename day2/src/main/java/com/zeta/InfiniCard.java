package com.zeta;

public class InfiniCard extends CreditCardBase implements ICreditCard{

    public InfiniCard(String customerName) {
        super(customerName);
    }

    @Override
    public boolean transaction(MerchantAccount account, float amount) {
        return false;
    }

    @Override
    public boolean withdrawCash(float amount) {
        return false;
    }
}
