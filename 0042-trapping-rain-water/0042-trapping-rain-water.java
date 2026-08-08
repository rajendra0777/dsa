/*
1. find left max & right max
2. substract left max with current element
3. keep adding the remaining and return it?

*/

class Solution {
    public int trap(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = Integer.MIN_VALUE;

        // calculating prefix
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }

        max = 0;

        // calculating suffix
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(left[i], right[i]) - arr[i];
        }
        return trappedWater;
    }
}