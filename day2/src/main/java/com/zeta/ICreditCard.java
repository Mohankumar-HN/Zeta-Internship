package com.zeta;

public interface ICreditCard {
    boolean transaction(MerchantAccount account, float amount);
    boolean withdrawCash(float amount);
}
