class Solution {
    /* Brute Force : Nested Loop (TLE)    
    TC:0(N^2)    
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)return nums[0];
        int maxSum = Integer.MIN_VALUE;
    
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+= nums[j];
               maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
    */
    /*
    Approach: Kadane's Algorithm (Calculate max sum of array in TC: O(n))
    TC: O(N)
    SC: O(1)
    */

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }

        }
        return maxSum;
    }

    /*  public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMax = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax+nums[i]);
            maxSum = Math.max(currentMax, maxSum);
        }
        return maxSum;
    }*/

}