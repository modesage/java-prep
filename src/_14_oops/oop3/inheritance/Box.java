package _14_oops.oop3.inheritance;
//every class has Object as superclass
// like here as Box is the Parent class, it will be derived from Object Class

//to prevent a class from inheritance when can make it final
//if a class is final implicitly its methods will be final too
//public final class Box{}
public class Box {

    double l;
    double h;
    double w;

    double weight;

    static void greeting(){
        System.out.println("hey im in Box class. Greetings!");
    }

    Box(){
        //whenever using inheritance, always need to initialize the variables
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box(double side){
        //cube
        //if we class super() here it will call the Object superclass
        //Class Object is the root of the class hierarchy. Every class has Object as a superclass.
        //All objects, including arrays, implement the methods of this class.
        super();
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box old){
        this.l = old.l;
        this.w = old.w;
        this.h = old.h;
    }

    public void information(){
        System.out.println("Running the box");
    }
}
