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
        int[] res = {0};
        helper(root, true, res);
        return res[0];
    }
    private int helper(TreeNode root, boolean fromLeft, int[] res) {
        if (root == null) return 0;
        int left = helper(root.left, true, res);
        int right = helper(root.right, false, res);
        res[0] = Math.max(res[0], Math.max(left, right));
        return fromLeft ? right + 1 : left + 1;
    }
}