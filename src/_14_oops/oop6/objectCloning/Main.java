package _14_oops.oop6.objectCloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human modesage = new Human(19, "modesage");
        //here we are making a copy of above object, but it is taking a lot of processing power
//        Human twin = new Human(modesage);
        //now this is a faster clone
        //a shallow copy is made
        //for PRIMITIVE values, new ref variables will create same values. eg: int etc.
        //for NON-PRIMITIVE value of Object, new ref variables will point to same objects. eg: Arrays, String etc.
        Human twin = (Human) modesage.clone();
        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(modesage.arr));

    }
}
