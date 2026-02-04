package com.zeta;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<ICreditCard> cards=new ArrayList<>();
    ICreditCard issueCard(String customer,CARD_TYPE type) {
        ICreditCard card;
        switch(type) {
            case INFINIA:
                card = new InfiniCard(customer);
                break;
            case EMERALD:
                card = new EmeraldCard(customer);
                break;
            default:
                throw new IllegalArgumentException("Invalid card type");
        }
        cards.add(card);
        return card;
    }
}
