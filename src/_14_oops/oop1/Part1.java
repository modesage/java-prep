package _14_oops.oop1;

public class Part1 {
    public static void main(String[] args){
        Student S1 = new Student(003,"modesage",100);
        S1.getName();
        S1.changeName("developer");
        S1.getName();
        S1.greeting();
        System.out.println(S1.rno);
        System.out.println(S1.marks);
    }

}
class Student {
    int rno;
    String name;
    float marks;

    void changeName(String name){
        this.name = name;
    }
    void greeting(){
        System.out.println("Welcome!");
    }
    void getName(){
        System.out.println(this.name);
    }

    Student(int rno, String name, float marks){
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    //when garbage collector is hit, below method will run
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
