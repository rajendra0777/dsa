class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid.length;
        int[] count = new int[(size * size) + 1];
        int missing = 0;
        int repeat = 0;
        
        for (int[] row : grid) {
            for (int num : row) {

                // int currentCount = count[num];
                //  count[num] = currentCount +1;

                count[num]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                repeat = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        return new int[] { repeat, missing };
    }
}