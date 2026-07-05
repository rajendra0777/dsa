/**
    Approach - Recursion + Backtracking
    
    T.C. O(N*2^N)

    S.C. O(N) - tempList
         O(N) - Auxillury Space (stack)
              - ansList will not consider for SC as it is O/P Space
     =>  O(N) + O(N) => O(2N)
         O(N) 
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        findSubsets(nums, 0, tempList, ansList);
        return ansList;
    }

    void findSubsets(int[] nums, int index, List<Integer> tempList, List<List<Integer>> ansList){
        if(index == nums.length){
            ansList.add(new ArrayList<>(tempList));
            return;
        }
        
        // Exclude
        findSubsets(nums, index + 1, tempList, ansList);

        // Include
        tempList.add(nums[index]);
        findSubsets(nums, index + 1, tempList, ansList);

        // Backtracking
        tempList.remove(tempList.size() - 1);
    }
}