/*
     0  1   2   3   4   5
    [7, 1,  5,  3,  6,  4]
        i
     
     min: buy index max > min - 0
     max: sell index max > min - 0
     
     [7,    6,  4,  3,  1]
                        i
     min=4
     max=4
     
     [1]
     
     TC: O(n)
     SC: O(1)
     [2,    4,  1]
                i
      min=0
      max=0
      
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
                max = i;
            } else if (prices[i] > prices[min]) {
                max = prices[max] > prices[i] ? max : i;
                profit = Math.max(profit, prices[max] - prices[min]);
            }
        }
        return profit;
    }
}