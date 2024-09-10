package _14_oops.oop5.interfaces.extendingDemo2;
public class Main implements A,B {

    //the access modifier of the overridden method should be same or better when overriding not less.
    //in B it is default so here it can
    @Override
    public void greet() {

    }

    public static void main(String[] args) {
        A.greeting();
    }
}