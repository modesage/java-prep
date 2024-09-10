package _14_oops.oop7.enumExample;

public class Basic {
    //Enums in Java are a special data type that allows for a variable to be a set of predefined constants
    //Enum values are objects themselves, providing identity, state, and behavior
    //Enums in Java do not require the creation of new objects because enum instances are predefined constants
    //that are ready-made and do not need to be instantiated like regular classes.
    //When working with enums, you access them directly through their type without
    //the need to create objects of the enum initialization class.

    //enum cannot extend Class, but can implement Interface
    //we cannot inherit a enum as well, so there cant be any abstract methods.
    enum Week implements Greet{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        //these are enum constants
        //public, static and final
        //since its final you cannot create child enums
        //type is Week

//        void display(); //abstract method not allowed
        void display(){
            System.out.println("inside display method");
        }

        Week(){
            System.out.println("constructor is called for " + this);
        }


        @Override
        public void hello() {
            System.out.println("hello from the outside!");
        }
        //this is not public or protected, only private or default
        //because we don't want to create new objects

        //internally: public static final Week Monday = new Week();

    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
//        for(Week day: Week.values()){
//            System.out.println(day);
//        }
//        System.out.println(week);

        //gives the position of enum
//        System.out.println(week.ordinal());

        week.hello();
        System.out.println(Week.valueOf("Tuesday"));
        week.display();
    }
}
