/*
1. find left max & right max
2. substract left max with current element
3. keep adding the remaining and return it?

Optimal way 
The side with the smaller current height limits the water.
Use two pointers:
left at the start, right at the end.
leftMax stores the tallest seen so far from the left.
rightMax stores the tallest seen so far from the right.
Move the pointer on the smaller side inward:
If height[left] < height[right]:
If height[left] < leftMax, water += leftMax − height[left].
Else update leftMax.
Move left forward.
Else do the symmetric steps on the right.
*/

class Solution {

    /* Brute Solution: Prefix and Suffix Arrays
    Time:  O(n + n + n) = O(3n), Space O(2n)
    Space: O(n), Space O(n)
    */
    public int trap(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = Integer.MIN_VALUE;

        // calculating prefix
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }

        max = 0;

        // calculating suffix
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(left[i], right[i]) - arr[i];
        }
        return trappedWater;
    }

    /* Brute Solution: Suffix Arrays
    Time:  O(n + n) = O(n),
    Space: O(n)
    */
    
    public int trap(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftMax = Integer.MIN_VALUE;

        // calculating suffix 
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            trappedWater += Math.min(leftMax, right[i]) - arr[i];
        }
        return trappedWater;
    }
*/
    /* Optimal Solution: Two-Pointer Technique
    Time: O(n)
    Space: O(1)
    */
    public int trap(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int left = 0;
        int right =n-1;

        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while(left<right){
            if(arr[left]<arr[right]){
                if(arr[left]>=leftMax){
                    leftMax = arr[left];
                }else{
                  trappedWater+=  leftMax - arr[left]; 
                }
                left++;
            }else{
                if(arr[right]>= rightMax){
                    rightMax = arr[right];
                }else{
                  trappedWater+=  rightMax - arr[right];
                }
                right--;
            }
        }
        return trappedWater;
    }    
}
