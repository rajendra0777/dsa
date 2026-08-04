class Solution {
    public List<Integer> majorityElement(int[] nums) {       
    
    List<Integer> list = new ArrayList<>();
    if(nums == null || nums.length == 0)return list;
    
    int candidate1 = 0;
    int candidate2 = 0;

    int count1 = 0;
    int count2 = 0;  

    for(int i = 0; i<nums.length; i++){
        if(count1> 0 && nums[i]== candidate1){
            count1++;
        }else if(count2> 0 && nums[i]== candidate2){
            count2++;
        }else if(count1 == 0){
            candidate1  = nums[i];
            count1++;
        }else if(count2 == 0){
            candidate2 = nums[i];
            count2++;
        }else{
            count1--;
            count2--;
        }
    }

    count1 = 0;
    count2 = 0;

    // Reset counters and manually recount from scratch
    for(int i : nums){
        if(i == candidate1){
            count1++;
        }else if(i == candidate2){
            count2++;
        }
    }

    int thresold = nums.length/3;
    if(candidate1 == candidate2 && count1>thresold){
        list.add(candidate1);
        return list;
    }

    if(count1>thresold) list.add(candidate1);
    if(count2> thresold)list.add(candidate2);
    return list;
    }
}