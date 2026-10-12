class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, temp, result);
        return new ArrayList(result);
    }

    private void subset(int [] arr, int index, List<Integer> temp, Set<List<Integer>> result){

        if(index == arr.length){
            result.add(new ArrayList(temp));
            return;
        }

        // take
        temp.add(arr[index]);
        subset(arr, index+1, temp, result);

        // not take
        int next = index +1;
       // while(next<arr.length && next!=index){
      //      next += 1;
      //  }
        temp.remove(temp.size()-1);
        subset(arr,next,temp, result);
    }
}