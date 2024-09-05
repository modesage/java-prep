package _12_bitwise;

public class UniqueElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,3,2,1};
        System.out.println(unique(arr));
    }
    static int unique(int[] arr){
        int element = 0;
        for(int num : arr){
            element = element ^ num;
        }
        return element;
    }

}
