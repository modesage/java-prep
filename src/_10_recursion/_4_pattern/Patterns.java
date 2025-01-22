package _10_recursion._4_pattern;

public class Patterns {
    public static void main(String[] args) {
//        triangle(4,0);
        triangle2(4,0);
    }
    static void triangle(int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            System.out.print("*");
            triangle(r,++c);
        } else{
            System.out.println();
            triangle(--r,0);
        }
    }
    static void triangle2(int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            triangle2(r,++c);
            System.out.print("*");
        } else{
            triangle2(--r,0);
            System.out.println();
        }
    }
}
