package _14_oops.oop6.objectCloning;

import java.util.Arrays;

//this interface will tell JVM that there will be cloning done
public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{2,5,33,55,21};
    }
//    public Human(Human other){
//        this.age = other.age;
//        this.name = other.name;
//    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //this is shallow copy creation
//        return super.clone();

        //this is deep copy creation, specific to our use case
        Human twin = (Human)super.clone();//shallow copy
//        twin.arr = new int[twin.arr.length];
//        for (int i = 0; i < twin.arr.length; i++) {
//            twin.arr[i] = this.arr[i];
//        }
//        twin.arr = this.arr.clone(); // Clone the array to avoid reference issues
        twin.arr = Arrays.copyOf(this.arr, this.arr.length); // Deep copy of the array
        return twin;
    }
}
