package com.zeta.transcation;

import java.time.ZonedDateTime;

public class Transcation {
    private int number;
    private String type;
    private int amount;
    private ZonedDateTime time;

    public Transcation(int number,String type,int amount){
        this.number=number;
        this.type=type;
        this.amount=amount;
        this.time=ZonedDateTime.now();
    }

    public int getNumber(){
        return number;
    }
    @Override
    public String toString(){
        return "Account : " + number +
                ", Type : " + type +
                ", Amount : " + amount +
                ", Time : " + time;
    }
}
