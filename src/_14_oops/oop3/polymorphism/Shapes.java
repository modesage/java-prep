package _14_oops.oop3.polymorphism;

public class Shapes {
    //final method cannot be overridden
    //call to one can be resolved at compile time only
    //so that is called as EARLY BINDING when using final
//    final void area(){
//        System.out.println("I am in shapes.");
//    }
    void area(){
        System.out.println("I am in shapes.");
    }
}
