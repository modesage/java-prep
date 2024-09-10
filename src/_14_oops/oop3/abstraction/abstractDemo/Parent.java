package _14_oops.oop3.abstraction.abstractDemo;

/*

    An abstract class cannot be instantiated directly,
    but it can be extended by other classes to provide implementations for its abstract methods.

    abstract classes in Java are indeed just templates to be overridden.
    An abstract class is a class that is declared with the abstract keyword and may contain
    both abstract and non-abstract methods.
    Abstract methods are methods that are declared without an implementation block,
    and they must be overridden in the subclasses to make the object usable.
    This is because abstract methods are used to define a common interface for subclasses to implement,
    allowing for re-usability and polymorphism in the code.

*/

//cant create objects of abstract classes
//so we cant create abstract constructors of abstract classes
// we cant create abstract static methods as,
// abstract meaning they have to be overridden and static methods cant be overridden.

// cant make final abstract class as, final means cant change and abstract means needs to be overridden
/*  The final keyword in Java is used to restrict the modification of variables, methods, or classes.
    When a variable is declared as final, its value cannot be changed once it has been initialized.
    This is useful for declaring constants or other values that should not be modified.
    Similarly, when a method is declared as final, its implementation cannot be overridden by subclasses.
    This is often used to ensure that certain methods have a specific implementation that cannot be changed.
    Finally, when a class is declared as final, it cannot be extended by other classes,
    which can be useful for creating immutable classes like the predefined String class
*/

//still multiple inheritance is not possible as there is no interface.
public abstract class Parent {
    int age;
    //creating this constructor so that it can be used by derived classes by super keyword
    //the object of this abstract class cant be created from this constructor
    //here creating constructor only makes sense when we have some final values
    final int VALUE;
    public Parent(int age) {
        this.age = age;
        VALUE = 31341;
    }
    static void hello(){
        System.out.println("hello from the other side!");
    }
    void normal(){
        System.out.println("this is a normal method ");
    }

    abstract void career();
    abstract void partner();
}
