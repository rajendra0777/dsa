/*
Approach : Brute Force
TC: O(n^n)
SC: O(1)
*/
class Solution {
/*    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
*/

/*
Approach: Prefix Sum
    1. Calcuate prefix sum 
    2. calculate maxProfit = prefixSum[i] - prices[i]
TC: O(n)
SC: O(n)    
*/
    public int maxProfit(int[] prices) {
        int[] prefix = prefixSum(prices);
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prefix[i]-prices[i]);
        }
        return maxProfit;
    }

    private int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[prefix.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= prefix[i + 1]) {
                prefix[i] = arr[i];
            } else {
                prefix[i] = prefix[i + 1];
            }
        }
        return prefix;
    }
}