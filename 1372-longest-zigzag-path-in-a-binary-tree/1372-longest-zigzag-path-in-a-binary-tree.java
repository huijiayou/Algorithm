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
    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] res = {0};
        helper(root, true, res, 0);
        return res[0] - 1;
    }
    private void helper(TreeNode root, boolean fromLeft, int[] res, int level) {
        res[0] = Math.max(res[0], level);
        if (root == null) return;
        if (fromLeft) {
            helper(root.right, false, res, level + 1);
            helper(root.left, true, res, 1);
        } else {
            helper(root.left, true, res, level + 1);
            helper(root.right, false, res, 1);
        }
    }
}