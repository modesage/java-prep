package _14_oops.oop3.encapsulation.access;

public class ObjectDemo {
    int num;
    float gpa;

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    //returns the string representation
    @Override
    public String toString() {
        return super.toString();
    }

    //finalize runs when garbage collection hits
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    //gives the number representation of the object by some internal algo and maths
    //giving random unique number for the object
    //if the hashcode is same then the object is same
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //checks the value not that the variable is pointing to the same object
    @Override
    public boolean equals(Object obj) {
        //here taking the num value
        return this.num == ((ObjectDemo)obj).num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(34, 56.7f);
//        System.out.println(obj.hashCode());
        ObjectDemo obj2 = new ObjectDemo(34, 78.9f);

        //only checking that the variable is pointing to the same object or not
        if(obj == obj2){
            System.out.println("obj is equal to obj2 by pointing to same place");
        }
        //checking the value of the obj
        if(obj.equals(obj2)){
            System.out.println("obj is equal to obj2 by the same value");
        }

    }

}
