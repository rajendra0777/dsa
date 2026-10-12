/*
Approach : Recursion + Backtracking
TC: O(2^n) // generate all possible set
insert into set(result) : O(x)// x -avg size

SC: O(2^n * x)
*/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums); // log(n)
        subset(nums, 0, temp, result);
        return new ArrayList(result);
    }

    private void subset(int[] arr, int index, List<Integer> temp, Set<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList(temp));
            return;
        }

        // take
        temp.add(arr[index]);
        subset(arr, index + 1, temp, result);
        
        int next = index+1;
        // not take
        temp.remove(temp.size() - 1);
        subset(arr, next, temp, result);
    }
}