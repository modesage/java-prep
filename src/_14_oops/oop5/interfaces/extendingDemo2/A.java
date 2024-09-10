package _14_oops.oop5.interfaces.extendingDemo2;

public interface A {
    //here the below method in interface we have not overridden as default implementation is done
    default void fun(){
        System.out.println("i am in A");
    }
    //static interface methods should always have a body
    //as they cant be inherited the same content will be used from the interface
    //call via thew interface name
    static void greeting(){
        System.out.println("Hello World!");
    }
}
