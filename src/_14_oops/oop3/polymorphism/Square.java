package _14_oops.oop3.polymorphism;

public class Square extends Shapes{
    //overriding happens at runtime ao it is also called as LATE BINDING
    @Override//just a simple check, will show error if it is not overriding
    //so for method overriding everything should be same(the return type, method name, parameters) only body is different
    void area(){
        System.out.println("Area: side * side");
    }
}
