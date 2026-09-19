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
    Appraoch: Recursion
    TC: O(N)
    SC: O(N)

 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        
        if(root == null)return list;
        dfs(root, 0, list);
        return list;

        
    }

    private void dfs(TreeNode root, int level, List<Integer> list){

        if(list.size() == level){
            list.add(root.val);
        }

        if(root.right!=null){
            dfs(root.right, level+1, list);
        }

        if(root.left!=null){
            dfs(root.left, level+1, list);
        }
        
    }
}