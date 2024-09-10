package _14_oops.oop6.generics;

import java.util.Arrays;

/*
Generics in Java are a powerful feature introduced in J2SE 5 to enhance type safety
and make programming more efficient. They allow the creation of parameterized types,
enabling classes, methods, and interfaces to operate on different data types.
Generics ensure type safety by detecting errors at compile time, preventing runtime issues like type casting errors.
By using generics, code becomes more stable and readable, promoting reusability
and reducing the need for manual type casting.
Generics in Java offer advantages such as type-safety, eliminating the need for type casting,
and providing compile-time checking to prevent runtime errors*/

public class CustomGenericArrayList<T> {
    //instance variable
    //here Object is the bigger type on which casting will be done of T type
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenericArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }
    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        //copy the current items in new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull(){
        return size == data.length;
    }

    public T remove(){
        //not deleting the element, just returning the element
        T remove = (T) (data[--size]);
        return remove;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        CustomArrayList list = new CustomArrayList();
//        list.add(3);
//        list.add(5);
//        list.add(9);
//        System.out.println(list);

        WildcardExample<Integer> list = new WildcardExample<Integer>();
        for (int i = 0; i < 14; i++) {
            list.add(2*i);
        }
        System.out.println(list);
    }
}
