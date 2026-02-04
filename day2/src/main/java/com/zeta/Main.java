package com.zeta;

public class Main {

    public static void main(String[] args){
        Bank bank=new Bank();
        Customer customer1=new Customer("mohan");
        Customer customer2=new Customer("kumar");

        bank.issueCard(customer1.name,CARD_TYPE.INFINIA);
        bank.issueCard(customer2.name,CARD_TYPE.EMERALD);
        System.out.println(bank.cards);
    }
}
