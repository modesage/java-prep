package _14_oops.oop3.inheritance;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box();
//        System.out.println(box1.l + " " + box1.w + " " + box1.h);
//        BoxWeight box3 = new BoxWeight(2,3,4,5);
//        System.out.println(box3.l + " " + box3.h + " " + box3.w + " " + box3.weight);

        // it is actually the type of reference variable and not the type of object
        // that determines what members can be accessed
        //here the object of type BoxWeight is able to call the Parent Class constructor Box
        // thereby initialising the l,h,w
        //but as the ref variable is of type Box(Parent Class) it is not able to access sub-class property
//        Box box5 = new BoxWeight(2,3,4,8);
        //so here we cant access box5.weight
//        System.out.println(box5.l);

        //here as the object is of type Box(Parent Class)
        // it is not knowing about the sub-classes, so weight could not be initialised
        //meaning the BoxWeight constructor could not be called.
//        BoxWeight box6 = new Box (2,3,4);
//        System.out.println(box6.l);

        //multilevel inheritance
//        BoxPrice box = new BoxPrice(5,8,200);

        // this is a static method, so it will be called from the class Box
        // as static methods are object independent
        // so no object is to be made for calling.
//        Box.greeting();

        //static method cannot be overridden
        //so even if BoxWeight had greeting(), Box greeting() is called
        Box box = new BoxWeight();
        box.greeting();

    }
}
