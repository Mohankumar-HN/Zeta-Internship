package com.zeta;

public class EmeraldCard extends CreditCardBase implements ICreditCard {


    public EmeraldCard(String customerName) {
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
