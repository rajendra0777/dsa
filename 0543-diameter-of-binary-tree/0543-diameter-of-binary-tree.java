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

 TC: O(n^2)
 SC: O(Height)
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

    // Diameter
    int diameter = height(root.left) + height(root.right);
    
    // recursive call
    int leftDia = diameterOfBinaryTree(root.left);
    int rightDia = diameterOfBinaryTree(root.right);

    return Math.max(diameter, Math.max(leftDia, rightDia));
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) +1;
    }

 /*    private int height(TreeNode root, int diameter) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) +1;
    }

    */
}