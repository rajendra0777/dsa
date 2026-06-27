class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if (m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i : bloomDay) {
            high = Math.max(i, high);
            low = Math.min(i, low);
        }

        int res = -1;

        //1,10,3,10,2
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBloom(bloomDay, mid, m, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;

    }

    private boolean canBloom(int[] bloomDay, int mid, int m, int k) {
        int bouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= mid) {
                count++;

                if (count == k) {
                    bouquets++; // one bouque
                    count = 0; // reset count for next
                }
            } else {
                count = 0; 
            }

            if (bouquets >= m)return true;
        }
        return false;
    }
}