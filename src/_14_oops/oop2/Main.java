package _14_oops.oop2;

public class Main {
    public static void main(String[] args) {
        //a object is created because no new objects were created before.
        SingletonClass obj1 = SingletonClass.getInstance();
        //here the same object will be given to point to
        SingletonClass obj2 = SingletonClass.getInstance();
        //here the same object will be given to point to
        SingletonClass obj3 = SingletonClass.getInstance();

        //all 3 reference variables are pointing to the same object

    }
}
