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
Approach : Brute Force using Hashing
TC: O(N)
SC : O(N) + O(N) = O(2N) => O(N)
 */
class Solution {
    //List<Integer> list = new ArrayList<>();

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int target) {

        if (root == null || (root.left == null && root.right == null))
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();

            int rem = target - temp.val;
            if (set.contains(rem)) {
                return true;
            }

            set.add(temp.val);

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return false;
    }

}