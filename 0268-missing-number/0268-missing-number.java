class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        //int totalSum = 0;
        for (int i : nums) {
            sum-= i;
        }
        return sum;
    }
}