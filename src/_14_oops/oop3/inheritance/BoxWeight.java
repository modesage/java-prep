package _14_oops.oop3.inheritance;
//the sub-class will not be able to access the members which are private from the parent class
public class BoxWeight extends Box {
    double weight;
    public BoxWeight(){
        this.weight = -1;
    }

    //static methods cannot be overridden
//    @Override
    static void greeting(){
        System.out.println("hey im in BoxWeight class. Greetings!");
    }

    //same as Box box6 = new BoxWeight(box5)
    BoxWeight (BoxWeight other){
        super(other);
        weight = other.weight;
    }

    BoxWeight(double side, double weight){
        super(side);
        this.weight = weight;
    }


    public BoxWeight(double l, double h, double w, double weight) {
        //used to initialise values present in the parent class
        //super() also needs to be above the sub-class because the sub-class cares about the parent class
        super(l, h, w); //calling the parent class constructor

        //if we want to explicitly ref to super class stuff only
        System.out.println("weight in super class Box: " + super.weight);
        this.weight = weight;
    }
}
