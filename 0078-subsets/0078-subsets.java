/*
Approach : Recursion
TC: O(2^n) => to check all possible subset
SC: o(n) + o(n) => O(n) = Auxilary Space
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        subset(nums, 0, temp, result);
        return result;

    }

    void subset(int[] arr, int index, List<Integer> temp, List<List<Integer>> result) {

        // base case
        if (index == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // logic
        // pic
        temp.add(arr[index]);
        subset(arr, index + 1, temp, result);
        // not pick
        temp.remove(temp.size() - 1);
        subset(arr, index + 1, temp, result);

    }

}