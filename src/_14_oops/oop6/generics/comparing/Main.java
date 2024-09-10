package _14_oops.oop6.generics.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student a = new Student(13,96.79f);
        Student b = new Student(32, 98.9f);
        Student c = new Student(12, 91.9f);
        Student d = new Student(55, 92.9f);
        Student e = new Student(8, 89.9f);

        Student[] list = {a,b,c,d,e};
        System.out.println(Arrays.toString(list));
        //the sort method will use the compareTo method if overridden for sorting according to defined parameter
        //we can also provide inside the parameter
//        Arrays.sort(list, new Comparator<Student>() {
//            //sorting acc to rollno
//            @Override
//            public int compare(Student o1, Student o2) {
//                //ascending order
////                return (int)(o1.rollno - o2.rollno);
//                //descending order
//                return -(int)(o1.rollno - o2.rollno);
//            }
//        });
        //we can also write as lambda expressions
        //sorting acc to rollno
        Arrays.sort(list, (o1, o2) -> -(int)(o1.rollno - o2.rollno));
        System.out.println(Arrays.toString(list));

//        if(a.compareTo(b) < 0){
//            System.out.println(a.compareTo(b));
//            System.out.println("b has more marks than a");
//        }
    }
}
