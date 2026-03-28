package SlidingWindow;

/*
Best Time to buy and sell stocks Leetcode 121, Difficulty Easy

Question: You are given an array prices where prices[i] is the price of a given stock on the ith day

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
the future to sell that stock

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit return 0
*/

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int i=0; i<prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }

            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{10, 2, 3, 4, 6, 8};

        BestTimeToBuyAndSellStocks obj = new BestTimeToBuyAndSellStocks();
        int maxProfit = obj.maxProfit(prices);

        System.out.println("Maximum Profit: " + maxProfit);
    }    
}
