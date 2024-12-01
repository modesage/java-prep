package _10_recursion._2_basic;

public class Numbers {
    public static void main(String[] args) {
        nToOne(5);
//        oneToN(5);
//        nToOneToN(5);
    }

    static void nToOne(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        nToOne(--n);
    }

    static void oneToN(int n){
        //base condition
        if(n == 0){
            return;
        }
        //recursive call
        oneToN(n-1);
        //when recursive call is completed and coming back from the base condition
        System.out.println(n);
    }
    static void nToOneToN(int n){
        //base condition
        if(n == 0){
            return;
        }
        //this will be printed when recursion is being formed
        System.out.println(n);
        //recursive call
        nToOneToN(n-1);
        //when recursive call is completed and coming back from the base condition
        if(n != 1){
            System.out.println(n);
        }

    }
}
