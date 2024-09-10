package _14_oops.oop7.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        //ref variable can be of parent type
        //and the other object of child.
        //as ArrayList class is implementing List interface, it will override the methods in List for its implementation
        //interface extends interface
        //class implements interface

//        List<Integer> list = new ArrayList<>();
//        List<Integer> list2 = new LinkedList<>();

//        list2.add(5);
//        list2.add(10);
//        list2.add(15);
//        list2.add(20);
//        System.out.println(list2);

        //Vector is sorta like ArrayList as methods are sorta similar, as it is also implementing List.
        //but internal working is different.
        //in Vector only single thread can access the object, so it is Synchronised.

        //ArrayList is faster than Vector as it is non-Synchronised.
        //in ArrayList multiple threads can access the object, so it is non-Synchronised.
        //we can also make it synchronize in Java,
        //you can either use the Collections.synchronizedList() method or
        //opt for CopyOnWriteArrayList based on your specific concurrency requirements

        List<Integer> vector = new Vector<>();
        vector.add(2);
        vector.add(4);
        vector.add(6);
        vector.add(8);
        System.out.println(vector);



    }
}
