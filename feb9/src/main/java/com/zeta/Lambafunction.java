package com.zeta;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambafunction {
    static Predicate<Integer> predicate=(x)->x%2==0;
    static Consumer<String> consumerLambda=message-> System.out.println(message);

    public static void main(String[] args){
        //assignment-1

        System.out.println("Assigment 1 :printing message,using predicate(returns boolean),add");

        consumerLambda.accept("Hi");
        System.out.println(predicate.test(10));
        Calculator calc = (x, y) -> x + y;
        System.out.println(calc.add(2, 3));

        int[] arr={1,2,3,4,5,6};
        int value=2;


  //        assignment-2

        System.out.println("assignment 2: Increasing the value of array members by 2");
        ArrayIncrement arrayIncrement=ar->{
            for(int i=0;i<ar.length;i++)
            {
                ar[i]+=2;
            }
            return ar;
        };
        int[] result= arrayIncrement.increment(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");
        }



//        assignment-3

        System.out.println("assignment 3: Increasing the value of array members by a specified value");
        Arraypass arraypass=(ar,val)->{
            for(int i=0;i<ar.length;i++){
                ar[i]+=val;
            }
            return ar;
        };
        int[] result2=arraypass.increasebyvalue(arr,value);
        for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]+ " ");
       }

        //assignment -4


        System.out.println("assignment 4: Adding each 3rd elements of array ");
        Arraythirdelement arraythirdelement=(ar)->{
            int sum=0;
            for(int i=2;i<ar.length;i+=3){
                sum+=ar[i];
            }
            return sum;
        };
        int result3=arraythirdelement.increasethirdelement(arr);
        System.out.println(result3);

    }
}
