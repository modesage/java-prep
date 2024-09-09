package _12_bitwise;

import java.util.Arrays;

//Google
//leetcode
//832. Flipping and Image
public class FlipImage {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] result = flipAndInvertImage(arr);
        for (int[] arrElement : result) {
            System.out.println(Arrays.toString(arrElement));
        }
    }
    static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int k = image[i].length - 1;
            for (int j = 0; j < image[i].length; j++) {
                if(j <= k){
                    //here we are swapping and doing XOR by 1 to invert the number as well
                    //as anything XOR(^) by 1 is the compliment of that element
                    int temp = image[i][k] ^ 1;
                    image[i][k] = image[i][j] ^ 1;
                    image[i][j] = temp;
                    k--;
                }
            }
        }
        return image;
    }

}
