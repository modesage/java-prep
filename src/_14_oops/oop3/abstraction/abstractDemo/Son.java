package _14_oops.oop3.abstraction.abstractDemo;

public class Son extends Parent {
    public Son(int age) {
        super(age);
    }
    @Override
    void normal(){
        super.normal();
//        System.out.println("overridden normal method");
    }
    @Override
    void career(){
        System.out.println("i am going to be a doctor!");
    }
    @Override
    void partner(){
        System.out.println("i love pepper pots");
    }
}
