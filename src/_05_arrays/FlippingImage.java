package _05_arrays;

import java.util.Arrays;

//leetcode
//832. Flipping an Image
public class FlippingImage {
    public static void main(String[] args) {
        int[][] image = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
        int[][] result = flipAndInvertImage(image);
        for(int[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] newImage = new int[image.length][image.length];
        for (int i = 0; i < image.length ; i++) {
            int k = 0;
            for (int j = image[i].length - 1; j > -1 ; j--) {
                if(image[i][j] == 1) image[i][j] = 0;
                else image[i][j] = 1;
                newImage[i][k] = image[i][j];
                k++;
            }
        }
        return newImage;
    }
}
