/*
Approach: prefix & Suffix
TC: O(3n) ~ O(n)
SC: O(2n) ~ O(n)

Steps: 
    - Calculate prefix and suffix product
    - First element = suffix[0]
    -  Last element = prefix[n-2];
    - Mid element = prefix[i-1]* suffix[i+1];
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int[] res = new int[size];

        //calculate prefix
        prefix[0] = nums[0]; // 1, 2, 6, 24
        for (int i = 1; i < size; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        //calculate suffix
        suffix[size - 1] = nums[size - 1]; //24,24,12,4
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        res[0] = suffix[1];
        res[size - 1] = prefix[size - 2];

        for (int i = 1; i < size - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }
}
