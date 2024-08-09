package _05_arrays;
//leetcode
//1672. Richest Customer Wealth
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int result = maximumWealth(accounts);
        System.out.println(result);
    }
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int customer = 0; customer < accounts.length; customer++) {
            int currentWealth = 0;
            for (int bank = 0; bank < accounts[customer].length; bank++) {
                currentWealth += accounts[customer][bank];
            }
            if (currentWealth > maxWealth) maxWealth = currentWealth;
        }
        return maxWealth;
    }
}
