package _14_oops.oop3.encapsulation.access.protect;
import _14_oops.oop3.encapsulation.access.A;
//checking the protected capability in subclass different package
public class B extends A {
    public B(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        B obj = new B(10,"modesage");
        String name1 = obj.name;
//        System.out.println(name1);
        //instanceof operator
//        System.out.println(obj instanceof A);
//        System.out.println(obj instanceof B);
//        System.out.println(obj instanceof Object);
        //.getClass() used to get data about class, and it will be stored in HEAP
        System.out.println(obj.getClass().getName());

    }
}
