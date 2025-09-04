package practice.blind75.sliding_window;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int left = 0; //buy day
        int right = 1; //sell day
        int maxProfit = 0;
        while(right < prices.length){
            //we are getting profit
            if(prices[right] > prices[left]){
                int profit = prices[right] - prices[left];
                Math.max(profit, maxProfit);
            }
            //no profit
            else{
                left = right; //move the buy day to a cheaper price
            }
            right++;
        }
        return maxProfit;
    }
}
