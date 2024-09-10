package _14_oops.oop3.abstraction.abstractDemo;

public class Daughter extends Parent{

    public Daughter(int age) {
        super(age);

    }

    @Override
    void career(){
        System.out.println("i am going ot be a coder!");
    }
    @Override
    void partner(){
        System.out.println("i love Iron Man");
    }
}
