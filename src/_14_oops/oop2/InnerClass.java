package _14_oops.oop2;

//class Test {
//    static String name;
//    public Test(String name){
//        Test.name = name;
//    }
//}
public class InnerClass {

    //Test class is made static as now it wont need instances/objects of InnerClass
    //static stuff is resolved during compile time, be it class,variables,methods etc.
    static class Test {
        String name;
        public Test(String name){
            this.name = name;
        }

        //here giving my own toString() and overriding(annotation) it to return something of my choice.
        //so here the name
        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Shaurya");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);

        //oops.oop2.InnerClass$Test@5f184fc6
        //got this hash value as the println is internally calling the toString() method
        //which if does not find the toString() in object a , then the class Test,
        //it will use its own default toString() and printing it in this format.
        //now i have given my own toString() and returning the name.
        System.out.println(a);
    }
}
