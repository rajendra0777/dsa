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

        tempList.add(nums[index]);
        // Include
        findSubsets(nums, index + 1, tempList, ansList);

        // Exclude
        tempList.remove(tempList.size() - 1);
        findSubsets(nums, index + 1, tempList, ansList);
    }
}