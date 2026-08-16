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
 */
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                if (leftToRight) {
                    tempList.add(0, temp.val);
                } else {
                    tempList.add(temp.val);
                }
            }

            list.add(tempList);
            leftToRight = !leftToRight;
        }
        return list;

    }
}
