package com.zeta;

import java.util.function.BiFunction;
import java.util.function.Function;



class Util{
    int square(int x){
        return x*x;
    }
    static int sum(int x,int y){
        return x+y;
    }
}


public class Methodreferencedemo {
    public static void main(String[] args){
        Util util=new Util();
        Function<Integer,Integer> reference=util::square;
        System.out.println(reference.apply(2));

        BiFunction<Integer,Integer,Integer> reference2=Util::sum;
        System.out.println(reference2.apply(2,3));
    }
}
