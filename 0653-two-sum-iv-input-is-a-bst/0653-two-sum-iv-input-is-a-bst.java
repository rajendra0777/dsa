/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 Approach: Two Pointer
 TC: O(N) + O(N) => O(N)
 SC: O(N)        => O(N)

 */
class Solution {
    public boolean findTarget(TreeNode root, int target) {
        if(root == null || (root.left== null && root.right == null))return false;

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int left = 0;
        int right = list.size()-1;

        while(left<right){
            int first = list.get(left);
            int second   = list.get(right);
            int sum = first + second;

            if(target == sum){
                return true;
            }
            else if(target<sum){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list){

        if(root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}