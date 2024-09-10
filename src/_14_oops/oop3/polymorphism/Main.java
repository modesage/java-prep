package _14_oops.oop3.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Shapes square = new Square();
        //it will only call the object type method, which is Square()
        square.area();
    }
}
