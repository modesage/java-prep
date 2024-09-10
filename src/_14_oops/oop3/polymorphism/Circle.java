package _14_oops.oop3.polymorphism;

public class Circle extends Shapes {
    //this will run when obj of circle is created
    //hence it is overriding the parent method

    @Override //this is called annotation // used to check weather a method is overridden or not
    void area(){
        System.out.println("Area: pie * r * r");
    }
}
