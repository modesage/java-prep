package _05_arrays;

import java.util.ArrayList;
import java.util.List;

//leetcode
//1431. Kids With the Greatest Number of Candies
public class GreatestCandies {

    public static void main(String[] args) {
        int[] candies1 = {2,3,5,1,3};
        int extraCandies1 = 3;
        List<Boolean> result1 = kidsWithCandies(candies1, extraCandies1);
        System.out.println(result1);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //finding the maximum number of candies any kid currently has
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        //creating the result list
        List<Boolean> result = new ArrayList<>();

        //checking each kid
        for (int candy : candies) {
            //checking if adding extraCandies to this kid makes their count >= maxCandies
            if (candy + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
