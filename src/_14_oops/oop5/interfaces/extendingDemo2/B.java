package _14_oops.oop5.interfaces.extendingDemo2;

public interface B {
    //default access modifier
    void greet();

    //now here if we also give the same function with default, which will remove overriding
    //we get an error
    //so we again come back to same error which we were trying to fix with interfaces for multiple inheritance

//    default void fun(){
//        System.out.println("i am in A");
//    }
}
