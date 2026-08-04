/*
Algorithm: Bayre Moore's Voting Algorithm (Optiomized)
TC: O(N)
SC: O(1)

Other approaches :
1. Frute Force- TC:O(n^2), SC: O(1)
2. Sort and Count the Each element Frequency- TC: O(NlogN), SC: O(1)
3. Using Hashmap - TC: O(N), SC: O(N)

Steps: 
If different element finds then make it current element (if count = 0)
If same element matches then -> count++;
If not then count--;
*/

class Solution {
    public int majorityElement(int[] arr) {
         int ansIndex = 0;
	    int count = 1;
	    
	    for(int i = 1; i<arr.length;i++){
	        if(arr[i] == arr[ansIndex]){
	            count++;
	        }else{
	            count--;
	        }
	        
	        if(count==0){
	            ansIndex = i;
	            count = 1;
	        }
	    }
	    // Check for the Majority Element
	    int freqCount = 0;
	    for(int i = 0; i<arr.length; i++){
	        if(arr[i] == arr[ansIndex]){
	            freqCount++;
	        }
	    }
	    int length = arr.length;
	    if(freqCount > length/2){
	        return arr[ansIndex];
	    }
	    
	    return -1;
    }
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                current = nums[i];

            if (current == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return current;
    }
}
*/