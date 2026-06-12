class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int currentLoad = 0;
            int day = 1;

            for (int w : weights) {
                if (currentLoad + w > mid) {
                    currentLoad = 0;
                    day++; // add weight to the next day
                }
            // requires for every package
            currentLoad += w;
            }

            if (day <= days) { // try to find smaller capacity in left
                right = mid;
            } else {
                left = mid + 1; // try to find in right
            }

        }
        return left;
    }
}