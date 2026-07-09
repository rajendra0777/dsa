/*
Approach: Recursion + Backtracking
    Idea: 
    - Sort the array for unique elements
    - include   (add)
    - backtrack  (go back)
    - check for the duplicate
    - exclude (remove)

TC: O(2^n . n) 
SC: O(n)
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        Arrays.sort(nums);
        findSubset(nums, 0, tempList, ansList);
        return ansList;

    }

    void findSubset(int[] nums, int index, List<Integer> tempList, List<List<Integer>> ansList) {
        if (index == nums.length) {
            ansList.add(new ArrayList<>(tempList));
            return;
        }

        //1. includ
        tempList.add(nums[index]);
        findSubset(nums, index + 1, tempList, ansList);
        
        //2. backtrack
        tempList.remove(tempList.size() - 1);
       
         //3. Skip all duplicate elements for the "exclude" decision
        while(index+1 < nums.length && nums[index]==  nums[index+1]){
            index++;
        }

        //4. exclude
        findSubset(nums, index + 1, tempList, ansList);
    }
}