package _14_oops.oop6.generics;

import java.util.Arrays;
import java.util.List;

//here T should either be Number or its sub-classes
//meaning only Integer, Float etc will be allowed but no String
public class WildcardExample<T extends Number> {
    //instance variable
    //here Object is the bigger type on which casting will be done of T type
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    //you can only pass Number type and not its sub-lasses like Integer, Float etc
    public void getList(List<Number> list){
        //do something
    }
    //now you can give Number type and its sub-lasses like Integer, Float etc
    //this is a wildcard
    public void getList2(List<? extends Number> list2){
        //do something
    }

    public WildcardExample() {
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
