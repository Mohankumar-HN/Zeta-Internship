package com.zeta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Bank {


    Logger logger=Logger.getLogger("bank");
    public boolean transfer(Account account1,Account account2,float amount) {
        try {
            float result = account1.withdraw(amount);
            System.out.println("Balance :"+account1.getBalance());
        } catch (InsufficientBalanceException insufficientBalanceException) {
            logger.severe(insufficientBalanceException.getMessage());
            return false;
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.severe(illegalArgumentException.getMessage());
            return false;
        }
        account2.deposit(amount);
        return true;
    }

}
