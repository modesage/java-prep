package _14_oops.oop3.abstraction.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son obj1 = new Son(30);
//        Daughter obj2 = new Daughter(28);
        //left side ref variable means which is can access
        //right side object means which it is accessing, overriding and type of object
        Parent obj2 = new Daughter(28);
        obj1.career();
        obj2.career();
        Parent.hello();
        obj1.normal();
    }
}
