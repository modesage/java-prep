package _05_arrays;
//leetcode
//1732. Find the Highest Altitude
public class HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        int result = largestAltitude(gain);
        System.out.println(result);
    }
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        for (int i = 0; i < gain.length ; i++) {
            currentAltitude += gain[i];
            if(currentAltitude > maxAltitude) maxAltitude = currentAltitude;
        }
        return maxAltitude;
    }
}
