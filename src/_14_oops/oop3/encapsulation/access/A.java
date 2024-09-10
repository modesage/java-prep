package _14_oops.oop3.encapsulation.access;

public class A {
    //scope in same class
    private int num;
    //scope in same package,class,sub-class,diff package sub-class
    protected String name;
    //default access modifier(scope in same package,class,sub-class)
    int[] arr;
    //scope everywhere
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }

}
