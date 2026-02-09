package com.zeta.list;

import java.util.ArrayList;
import java.util.List;

public class LambdawithCollection {
    public static void main(String[] args){
        showWithArrayList();
    }

    public static void showWithArrayList(){
        List<AccountLambda> accounts=new ArrayList<>();
        for(int i=0;i<10;i++){
            accounts.add(new SavingsAccount(i+1));
        }
        accounts.forEach(account -> System.out.println(account.getNumber()) );
        System.out.println("After sorting.....");
        accounts.sort((AccountLambda account1,AccountLambda account2)-> account2.getNumber()- account1.getNumber());
        accounts.forEach(account-> System.out.println(account.getNumber()));
        accounts.removeIf(account->account.getNumber()%2==0);
        System.out.println("After removal...");
        accounts.forEach(account-> System.out.println(account.getNumber()));
    }
}
