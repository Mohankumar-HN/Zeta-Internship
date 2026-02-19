package com.zeta;

import java.util.HashMap;
import java.util.Map;

class Mykey{
}


public class MapDemo {
    public static void main(String[] args){
        customKey();
    }

    private static void customKey(){
        Map<Mykey,String> map=new HashMap<>();
        Mykey key=new Mykey();
        Mykey key1=new Mykey();
        map.put(key,"value1");
        map.put(key1,"value2");
        System.out.println(map.get(key1));
    }

    private static void basics(){
        Map<String,String> map=new HashMap<>();
        map.put("1","value1");
//        System.out.println(map.put("1","value2"));
//        System.out.println(map.put(null,"value2"));
//        map.remove(null);
//        System.out.println(map);
//        map.forEach((key,value)-> System.out.println(key));
    }

}
