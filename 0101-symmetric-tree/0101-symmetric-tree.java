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
// Mirror Tree : Left node should be in right and vice versa

 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root, root); 
    }

    boolean isMirror(TreeNode p, TreeNode q){
        if(p==null && q == null)return true;

        if((p !=null && q!=null) && (p.val == q.val)){
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        return false;
    }
}