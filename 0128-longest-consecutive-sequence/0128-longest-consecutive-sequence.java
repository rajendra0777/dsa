
/* Approach : HashSet
TC: O(N)
SC: O(N)
*/
class Solution {
public int longestConsecutive(int[] nums) {

        if(nums.length==0) return 0;


        Arrays.sort(nums);

        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {
            int def = nums[i] - nums[i - 1];
            if (def == 1) {
                current++;
                longest = Math.max(longest, current);
            } else if (def > 1) {
                current = 1;
            }
        }
        return longest;
    }
/* Approch : hashSet (TLE)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 1)
            return (nums.length==1)?1:0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }
                longest = Math.max(longest, currentCount);
            }
        }
        return longest;

    }*/
}