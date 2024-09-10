package _14_oops.oop2;

public class Part2 {
    public static void main(String[] args) {
        Human person1 = new Human("Shaurya", 19);
        Human person2 = new Human("Rahul", 20);
        System.out.println(Human.population);
        System.out.println(Human.population);
        Human.fun();
    }
}
class Human{
    String name;
    int age;
    static long population;

    public Human(){

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        Human.population += 1;
    }
    static void fun(){
        //cant call non-static inside static without making it static or giving its reference by making a object.
        //greeting();
        Human greet = new Human();
        greet.greeting();

    }
    void greeting(){
        System.out.println("Welcome!");
    }
}
